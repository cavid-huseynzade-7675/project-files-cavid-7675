package az.developia.compshopcavidhuseynzade.model;

public class SearchModel {
    
    private String search;
private Integer begin;
public Integer getBegin() {
    return begin;
}

public void setBegin(Integer begin) {
    this.begin = begin;
}

public Integer getLength() {
    return length;
}

public void setLength(Integer length) {
    this.length = length;
}

private Integer length;
    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}