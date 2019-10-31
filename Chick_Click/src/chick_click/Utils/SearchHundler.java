/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chick_click.Utils;

/**
 *
 * @author mahmoud
 */
public class SearchHundler {
      static private SearchHundler sh;
     private String search;
      public SearchHundler() {
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
      
       public static SearchHundler getInstance() {
        if (sh == null) {
            sh = new SearchHundler();
        }
        return sh;
    }
}
