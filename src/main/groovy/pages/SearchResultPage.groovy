package pages

import geb.Page
import modules.Loader
import modules.searchModules.SearchResult
import modules.heroContent.ItemListElement

class SearchResultPage extends Page {
//    static url is different for all search results
    static at = {
        searchResults.size() > 0
    }
    static content = {
        searchResults { $('.hotel-search-results .hotel-offer-wrapper').moduleList(SearchResult) }
        breadcrumbList { $('[property=itemListElement]').moduleList(ItemListElement) }
        loader { module Loader }
    }
}
