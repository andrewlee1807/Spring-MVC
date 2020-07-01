package com.abc.andrew.utils;

import com.abc.andrew.dto.AuthorDTO;
import com.abc.andrew.model.Author;

public class AuthorUtils {
    public static AuthorDTO convertEntityToDto(Author author) {
        return new AuthorDTO(author.getIdAuthor(), author.getName());
    }
}
