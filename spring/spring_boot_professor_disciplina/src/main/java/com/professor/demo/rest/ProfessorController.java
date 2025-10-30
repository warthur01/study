package com.professor.demo.rest;

import com.professor.demo.entity.Professor;
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
@RequestMapping("/api/professors")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    @Operation(summary = "List all professors", description = "Returns a list of all registered professors")
    public List<Professor> getAllProfessors() {
        return professorService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a professor by ID", description = "Returns the details of a specific professor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Professor found"),
            @ApiResponse(responseCode = "404", description = "Professor not found")
    })
    public ResponseEntity<Professor> getProfessorById(@PathVariable Long id) {
        Optional<Professor> professor = professorService.findById(id);
        return professor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create a new professor", description = "Adds a new professor to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Professor created successfully")
    })
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorService.save(professor);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a professor", description = "Updates the details of an existing professor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Professor updated successfully"),
            @ApiResponse(responseCode = "404", description = "Professor not found")
    })
    public ResponseEntity<Professor> updateProfessor(@PathVariable Long id, @RequestBody Professor professor) {
        try {
            Professor updatedProfessor = professorService.update(id, professor);
            return ResponseEntity.ok(updatedProfessor);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a professor", description = "Removes a professor from the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Professor deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Professor not found")
    })
    public ResponseEntity<Void> deleteProfessor(@PathVariable Long id) {
        try {
            professorService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}