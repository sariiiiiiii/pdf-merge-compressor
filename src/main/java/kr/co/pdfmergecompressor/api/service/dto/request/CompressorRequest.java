package kr.co.pdfmergecompressor.api.service.dto.request;

public record CompressorRequest(
        String folderPath,
        String outputPath
) {
}
