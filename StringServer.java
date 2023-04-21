import java.io.IOException;
import java.net.URI;

class StringHandler implements URLHandler {
    String message = "";

    public String handleRequest(URI url) {
        System.out.println(url);
        if (url.getPath().equals("/")) {
            return "Andrew Park's Homepage";
        } else if (url.getPath().equals("/add-message")) {
            String[] parameters = url.getQuery().split("="); // split the query string into two parts
            if (parameters[0].equals("s")) {
                message += parameters[1];
                message += "\n";
            }
            return message;
        } else {
            return "404 Not Found";
        }
    }
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }
        int port = Integer.parseInt(args[0]);
        Server.start(port, new StringHandler());
    }
}
