package modules.searchModules

import geb.Module

class SearchCategoryModule extends Module{
    static base = {$('.mq-tabs')}
    static content = {
        flights {$('.mq-tab[data-tab-id=Flights]')}
        hotels {$('.mq-tab[data-tab-id=Hotels]')}
        insurance {$('.mq-tab[data-tab-id=Insurance]')}
        cars {$('.mq-tab[data-tab-id=Cars]')}
    }
}
