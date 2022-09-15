package se331.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.rest.entity.Org;
import se331.rest.service.OrgService;

@Controller
public class OrgController {


    @Autowired
    OrgService orgService;

    @GetMapping("org")
    public ResponseEntity<?> getOrgLists(@RequestParam(value = "_limit", required = false) Integer perPage, @RequestParam(value = "_page", required = false) Integer page) {
        Page<Org> pageOutput = orgService.getOrgs(perPage, page);
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(pageOutput.getContent(), responseHeader, HttpStatus.OK);

    }

    @GetMapping("org/{id}")
    public ResponseEntity<?> getOrg(@PathVariable("id") Long id) {
        Org output = orgService.getOrg(id);
        if (output != null) {
            return ResponseEntity.ok(output);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/org")

    public ResponseEntity<?> addOrg(@RequestBody Org org) {

        Org output = orgService.save(org);

        return ResponseEntity.ok(org);

    }
}



