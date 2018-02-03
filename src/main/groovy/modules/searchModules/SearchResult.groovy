package modules.searchModules

import geb.Module

class SearchResult extends Module{
    static base = {$('.hotel-offer')}
    static content = {
        hotelDetails{$('')}
        priceDetails{$('')}
    }
}
