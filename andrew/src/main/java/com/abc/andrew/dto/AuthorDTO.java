package com.abc.andrew.dto;

public class AuthorDTO {
    private Integer idAuthor;
    private String name;

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthorDTO(Integer idAuthor, String name) {
        this.idAuthor = idAuthor;
        this.name = name;
    }

    public AuthorDTO() {
    }
//
//    @Override
//    public String toString(){
//        return "ID : " + this.getIdAuthor()+"\nName : " + this.getName() +  "\n";
//    }
}
