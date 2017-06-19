package juja.microservices.keepers.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import juja.microservices.keepers.entity.KeeperRequest;
import juja.microservices.keepers.service.KeepersService;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

import javax.validation.Valid;

import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.List;

/**
 * @author Vadim Dyachenko
 */

@RestController
public class KeepersController {

    @Inject
    private KeepersService keepersService;

    @PostMapping(value = "/keepers", consumes = "application/json", produces = "application/json")
    @ApiOperation(
            value = "Add new keeper",
            notes = "This method add new keeper"
    )
    @ApiResponses(value = {
            @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Returns array with one keeper id"),
            @ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message = "Bad request"),
            @ApiResponse(code = HttpURLConnection.HTTP_BAD_METHOD, message = "Bad method"),
            @ApiResponse(code = HttpURLConnection.HTTP_UNSUPPORTED_TYPE, message = "Unsupported request media type")
    })
    public ResponseEntity<?> addKeeper(@Valid @RequestBody KeeperRequest request) {
        String keeperId = keepersService.addKeeper(request);
        List<String> ids = Collections.singletonList(keeperId);
        return ResponseEntity.ok(ids);
    }

    @PutMapping(value = "/keepers", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateKeeper(@Valid @RequestBody KeeperRequest request) {
        //TODO Should be implemented feature KPR-F2
        return null;
    }

    @GetMapping(value = "/keepers/{uuid}", produces = "application/json")
    public ResponseEntity<?> getDirections(@PathVariable String uuid) {
        //TODO Should be implemented feature KPR-F3
        return null;
    }

    @GetMapping(value = "/keepers", produces = "application/json")
    public ResponseEntity<?> getKeepers() {
        //TODO Should be implemented feature KPR-F4
        return null;
    }
}
