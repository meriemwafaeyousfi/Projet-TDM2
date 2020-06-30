package com.example.geomob

import androidx.room.*

import java.lang.reflect.Type


@Entity
class Pays_Entity {

    @PrimaryKey(autoGenerate = true)
    var pays_id : Int =0

    @ColumnInfo(name = "pays_drap")
    var pays_drap : Int = 0

    @ColumnInfo(name = "pays_hymne")
    var pays_hymne : Int = 0

    @ColumnInfo(name = "pays_slide")
    var pays_slide : List<Int> = listOf(0, 0,0,0)

    @ColumnInfo(name = "pays_video")
    var pays_video : List<Int> = listOf(0,0,0,0)

    @ColumnInfo(name = "pays_nom")
    var pays_nom : String = ""

    @ColumnInfo(name = "pays_des")
    var pays_des : String = ""

    @ColumnInfo(name = "pays_population")
    var pays_population : String = ""

    @ColumnInfo(name = "pays_surface")
    var pays_surface : String = ""

}


@Entity
class Histo_Entity {

    @PrimaryKey(autoGenerate = true)
    var histo_id : Int =0

    @ColumnInfo(name = "histo_paysId")
    var histo_paysId : Int =0

    @ColumnInfo(name = "histo_date")
    var histo_date : String = ""

    @ColumnInfo(name = "histo_des")
    var histo_des : String = ""
}

@Entity
class Ress_Entity {

    @PrimaryKey(autoGenerate = true)
    var ress_id : Int =0

    @ColumnInfo(name = "ress_paysId")
    var ress_paysId : Int =0

    @ColumnInfo(name = "ress_nom")
    var ress_nom : String = ""

    @ColumnInfo(name = "ress_des")
    var ress_des : String = ""
}

@Entity
class Person_Entity {

    @PrimaryKey(autoGenerate = true)
    var person_id : Int =0

    @ColumnInfo(name = "person_paysId")
    var person_paysId : Int =0

    @ColumnInfo(name = "person_nom")
    var person_nom :String = ""

    @ColumnInfo(name = "person_des")
    var person_des : String = ""
}

data class PaysRhisto(
    @Embedded val pays: Pays_Entity,
    @Relation(
        parentColumn = "pays_id",
        entityColumn = "histo_paysId"
    )
    val histo : List<Histo_Entity>
)
data class PaysRress(
    @Embedded val pays: Pays_Entity,
    @Relation(
        parentColumn = "pays_id",
        entityColumn = "ress_paysId"
    )
    val ress : List<Ress_Entity>
)
data class PaysRperson(
    @Embedded val pays: Pays_Entity,
    @Relation(
        parentColumn = "pays_id",
        entityColumn = "person_paysId"
    )
    val person : List<Person_Entity>
)