package pages

import geb.Page
import modules.LoaderModule
import modules.heroContent.ItemListElement
import modules.searchModules.SearchResultModule

class SearchResultPage extends Page {
//    static url is different for all search results
    static at = {
        searchResults.size() > 0
    }
    static content = {
        searchResults { $('.hotel-search-results .hotel-offer-wrapper').moduleList(SearchResultModule) }
        breadcrumbList { $('[property=itemListElement]').moduleList(ItemListElement) }
        loader { module LoaderModule }
    }
}
