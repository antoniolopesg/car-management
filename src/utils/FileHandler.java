package utils;

import models.bean.Carro;

import java.io.*;
import java.text.SimpleDateFormat;

public class FileHandler {
    public static void writer(String path, Carro car) throws IOException {
        FileWriter fw = new FileWriter(path, true);
        BufferedWriter buff = new BufferedWriter(fw);
        buff.newLine();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        buff.append(car.getPlaca()).append(", ")
            .append(car.getAno()).append(", ")
            .append(car.getCor()).append(", ")
            .append(car.getMarca()).append(", ")
            .append(car.getModelo()).append(", ")
            .append(car.getChassi()).append(", ")
            .append(car.getProprietario()).append(", ")
            .append(sdf.format(car.getDataCompra()));

        buff.close();
    }
}
