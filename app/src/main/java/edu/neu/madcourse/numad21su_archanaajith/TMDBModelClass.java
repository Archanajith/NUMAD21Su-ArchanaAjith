package edu.neu.madcourse.numad21su_archanaajith;

public class TMDBModelClass {

    String id;
    String name;
    String img;
    String movieDescription;


    public TMDBModelClass(String id, String name, String img, String movieDescription) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.movieDescription=movieDescription;
    }

    public TMDBModelClass() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getDescription() {
        return movieDescription;
    }

    public void setDescription(String description) {
        this.movieDescription = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
