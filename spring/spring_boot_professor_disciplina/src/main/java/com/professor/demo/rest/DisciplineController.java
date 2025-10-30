package com.professor.demo.rest;

import com.professor.demo.entity.Discipline;
import com.professor.demo.entity.Professor;
import com.professor.demo.service.DisciplineService;
import com.professor.demo.service.ProfessorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/disciplines")
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    @Operation(summary = "List all disciplines", description = "Returns a list of all registered disciplines")
    public List<Discipline> getAllDisciplines() {
        return disciplineService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a discipline by ID", description = "Returns the details of a specific discipline")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Discipline found"),
            @ApiResponse(responseCode = "404", description = "Discipline not found")
    })
    public ResponseEntity<Discipline> getDisciplineById(@PathVariable Long id) {
        Optional<Discipline> discipline = disciplineService.findById(id);
        return discipline.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create a new discipline", description = "Adds a new discipline to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Discipline created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid professor ID")
    })
    public ResponseEntity<Discipline> createDiscipline(@RequestBody Discipline discipline) {
        // Ensure the professor exists
        if (discipline.getProfessor() != null && discipline.getProfessor().getId() != null) {
            Optional<Professor> professor = professorService.findById(discipline.getProfessor().getId());
            if (professor.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            discipline.setProfessor(professor.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(disciplineService.save(discipline));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a discipline", description = "Updates the details of an existing discipline")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Discipline updated successfully"),
            @ApiResponse(responseCode = "404", description = "Discipline or professor not found")
    })
    public ResponseEntity<Discipline> updateDiscipline(@PathVariable Long id, @RequestBody Discipline discipline) {
        try {
            Discipline updatedDiscipline = disciplineService.update(id, discipline);
            return ResponseEntity.ok(updatedDiscipline);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a discipline", description = "Removes a discipline from the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Discipline deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Discipline not found")
    })
    public ResponseEntity<Void> deleteDiscipline(@PathVariable Long id) {
        try {
            disciplineService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}