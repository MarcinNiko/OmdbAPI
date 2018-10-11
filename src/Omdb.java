import java.io.InputStream;
import java.net.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Omdb {

    static String charset = "UTF-8";
    static String APIkey = "81c13a05";
    private static final String url = "http://www.omdbapi.com/?apikey=81c13a05&";
    static Scanner InputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.println(sendGetRequest(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String sendGetRequest(String urlString) throws IOException {

        System.out.println("Enter title: ");
        String title = InputScanner.nextLine();

        String query = String.format("t=%s", URLEncoder.encode(title,charset));

        URLConnection connection = new URL(urlString + query).openConnection();
        connection.setRequestProperty("Accept-Charset", charset);


        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer response = new StringBuffer();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine + "\n");
        }
        in.close();

        return response.toString();
    }
    }


