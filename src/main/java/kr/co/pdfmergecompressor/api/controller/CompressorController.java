package kr.co.pdfmergecompressor.api.controller;

import kr.co.pdfmergecompressor.api.service.CompressorService;
import kr.co.pdfmergecompressor.api.service.dto.request.CompressorRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/merge")
@RequiredArgsConstructor
public class CompressorController {

    private final CompressorService compressorService;

    @PostMapping("/compressor")
    public ResponseEntity<?> compressor(@RequestBody final CompressorRequest request) {
        return ResponseEntity.ok(compressorService.compressor(request));
    }

}
