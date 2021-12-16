package com.example.xmlparseretrofit.feedModel

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "feed", strict = false)
class Feed constructor(): Serializable {
    @field:ElementList(inline = true, name = "entry")
    var entrys: List<Entry>? = null
}