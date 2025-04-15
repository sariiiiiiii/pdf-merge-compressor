package kr.co.pdfmergecompressor.api.service;

import com.itextpdf.kernel.pdf.*;
import kr.co.pdfmergecompressor.api.service.dto.request.CompressorRequest;
import kr.co.pdfmergecompressor.api.service.dto.response.CompressorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@Slf4j
@Service
public class CompressorService {

    public CompressorResponse compressor(final CompressorRequest request) {
        File folder = new File(request.folderPath());
        File[] pdfFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));

        if (pdfFiles == null || pdfFiles.length == 0) {
            log.info("No PDF files found in the specified folder.");
            return new CompressorResponse(false, "No PDF files found in the specified folder.");
        }

        Arrays.sort(pdfFiles);

        WriterProperties writerProperties = new WriterProperties();
        writerProperties.setCompressionLevel(CompressionConstants.BEST_COMPRESSION);
        writerProperties.setFullCompressionMode(true);
        writerProperties.useSmartMode();

        try {
            PdfWriter writer = new PdfWriter(request.outputPath(), writerProperties);

            PdfDocument mergedPdf = new PdfDocument(writer);

            for (File pdfFile : pdfFiles) {
                PdfDocument pdfToMerge = new PdfDocument(new PdfReader(pdfFile));
                pdfToMerge.copyPagesTo(1, pdfToMerge.getNumberOfPages(), mergedPdf);
                pdfToMerge.close();
            }

            mergedPdf.close();
            log.info("PDF files merged and compressed successfully. Output: {}",  request.outputPath());
            return new CompressorResponse(true, "PDF files merged and compressed successfully");
        } catch (IOException e) {
            log.error("Error during PDF merging or compression: {}", e.getMessage());
            return new CompressorResponse(false, e.getMessage());
        }
    }

}
