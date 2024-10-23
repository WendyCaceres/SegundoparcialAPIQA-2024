package config;

public class ApiProjectConfig {
    public static String host="https://todo.ly";

    public static final String CREATE_PROJECT=host+"/api/projects.json";
    public static final String UPDATE_PROJECT=host+"/api/projects/{id}.json";
    public static final String READ_PROJECT=host+"/api/projects/{id}.json";
    public static final String DELETE_PROJECT=host+"/api/projects/{id}.json";
    public static final String READ_ALL_PROJECT=host+"/api/projects.json";
}
