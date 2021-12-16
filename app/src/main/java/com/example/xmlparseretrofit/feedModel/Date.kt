package com.example.xmlparseretrofit.feedModel

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "releasedate" , strict = false)
class Date @JvmOverloads constructor(


    @field:Attribute(name = "label",required = false)
    var label: String? = null


): Serializable {
}