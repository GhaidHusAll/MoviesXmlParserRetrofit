package com.example.xmlparseretrofit.feedModel

import org.simpleframework.xml.*
import retrofit2.http.Path
import java.io.Serializable

@Root(name = "entry" , strict = false)
class Entry @JvmOverloads constructor(

    @field:Element(name = "name")
    @param:Element(name = "name")
    var name: String? = null,

    @field:Element(name = "summary")
    @param:Element(name = "summary")
    var summary: String? = null,

//    @field:Element(name = "category")
//    @param:Element(name = "category")
//    var category: String? = null,

    @field:Element(name = "artist")
    @param:Element(name = "artist")
    var artist: String? = null,

    @field:Element(name = "price")
    @param:Element(name = "price")
    var price: String? = null,

    @field:ElementList( name = "image",inline = true)
    var imageUrl: List<Image>? = null,


    @field:Element( name = "releaseDate")
    var releaseDate: Date? = null



): Serializable {
}