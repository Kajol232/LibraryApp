package com.muhammad.libraryapp.model.dtos;

import java.util.List;

public class UpdateDTO {
    private List<Long> ids;

    public UpdateDTO(List<Long> ids) {
        this.ids = ids;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
}
