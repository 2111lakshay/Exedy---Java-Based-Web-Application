package com.exedy;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class GenerateReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=product_report.pdf");

        String productIdParam = request.getParameter("productId");
        if (productIdParam != null && !productIdParam.isEmpty()) {
            // Generate report for a single product
            int productId = Integer.parseInt(productIdParam);
            generateProductReport(productId, response);
        } else {
            // Generate the whole report
            generateWholeReport(response);
        }
    }

    private void generateProductReport(int productId, HttpServletResponse response) throws IOException {
        try (PDDocument document = new PDDocument()) {
            ProductDAO productDAO = new ProductDAO();
            List<Product> productList = productDAO.getAllProducts(productId);

            int maxProductsPerPage = 4; // Maximum number of products per page
            int totalProducts = productList.size();
            int totalPages = (int) Math.ceil((double) totalProducts / maxProductsPerPage);

            for (int pageNumber = 0; pageNumber < totalPages; pageNumber++) {
                PDPage page = new PDPage();
                document.addPage(page);

                PDPageContentStream contentStream = new PDPageContentStream(document, page,
                        PDPageContentStream.AppendMode.APPEND, true, true);
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.setLeading(14.5f);
                contentStream.beginText();
                contentStream.newLineAtOffset(50, 700); // Set the initial y-coordinate for each page

                int startIndex = pageNumber * maxProductsPerPage;
                int endIndex = Math.min(startIndex + maxProductsPerPage, totalProducts);

                for (int i = startIndex; i < endIndex; i++) {
                    Product product = productList.get(i);

                    contentStream.showText("Product ID: " + product.getProductId());
                    contentStream.newLine();
                    contentStream.showText("Product Name: " + product.getProductName());
                    contentStream.newLine();
                    contentStream.showText("Functionality: " + product.getFunctionality());
                    contentStream.newLine();
                    contentStream.showText("Performance: " + product.getPerformance());
                    contentStream.newLine();
                    contentStream.showText("Usability: " + product.getUsability());
                    contentStream.newLine();
                    contentStream.showText("Cost: " + product.getCost());
                    contentStream.newLine();
                    contentStream.showText("Value: " + product.getValue());
                    contentStream.newLine();
                    contentStream.showText("Environmental Impact: " + product.getEnvironmentalImpact());
                    contentStream.newLine();
                    contentStream.showText("Customer Feedback: " + product.getCustomerFeedback());
                    contentStream.newLine();
                    contentStream.newLine();
                }

                contentStream.endText();
                contentStream.close();
            }

            document.save(response.getOutputStream());
        } catch (Exception e) {
            // Handle any exception that occurs during PDF generation
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error generating PDF");
        }
    }

    private void generateWholeReport(HttpServletResponse response) throws IOException {
        try (PDDocument document = new PDDocument()) {
            ProductDAO productDAO = new ProductDAO();
            List<Product> productList = productDAO.getAllProducts();

            int maxProductsPerPage = 4; // Maximum number of products per page
            int totalProducts = productList.size();
            int totalPages = (int) Math.ceil((double) totalProducts / maxProductsPerPage);

            for (int pageNumber = 0; pageNumber < totalPages; pageNumber++) {
                PDPage page = new PDPage();
                document.addPage(page);

                PDPageContentStream contentStream = new PDPageContentStream(document, page,
                        PDPageContentStream.AppendMode.APPEND, true, true);
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.setLeading(14.5f);
                contentStream.beginText();
                contentStream.newLineAtOffset(50, 700); // Set the initial y-coordinate for each page

                int startIndex = pageNumber * maxProductsPerPage;
                int endIndex = Math.min(startIndex + maxProductsPerPage, totalProducts);

                for (int i = startIndex; i < endIndex; i++) {
                    Product product = productList.get(i);

                    contentStream.showText("Product ID: " + product.getProductId());
                    contentStream.newLine();
                    contentStream.showText("Product Name: " + product.getProductName());
                    contentStream.newLine();
                    contentStream.showText("Functionality: " + product.getFunctionality());
                    contentStream.newLine();
                    contentStream.showText("Performance: " + product.getPerformance());
                    contentStream.newLine();
                    contentStream.showText("Usability: " + product.getUsability());
                    contentStream.newLine();
                    contentStream.showText("Cost: " + product.getCost());
                    contentStream.newLine();
                    contentStream.showText("Value: " + product.getValue());
                    contentStream.newLine();
                    contentStream.showText("Environmental Impact: " + product.getEnvironmentalImpact());
                    contentStream.newLine();
                    contentStream.showText("Customer Feedback: " + product.getCustomerFeedback());
                    contentStream.newLine();
                    contentStream.newLine();
                }

                contentStream.endText();
                contentStream.close();
            }

            document.save(response.getOutputStream());
        } catch (Exception e) {
            // Handle any exception that occurs during PDF generation
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error generating PDF");
        }
    }
}
