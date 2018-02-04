package modules.heroContent

import geb.Module

class ItemListElement extends Module {
    static content = {
        propertyName { $('[property=name]') }
    }
}
