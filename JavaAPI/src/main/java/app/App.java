package app;

import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {


        Javalin app = Javalin.create();
        establishRoutes(app);

        app.start(7001);

    }

    private static void establishRoutes(Javalin app) {
        //just need to add correct path based on url

        //app.get("",Controllercalls here);

    }

}
