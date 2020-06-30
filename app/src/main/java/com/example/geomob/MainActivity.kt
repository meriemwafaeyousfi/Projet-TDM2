package com.example.geomob
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.geomob.R
import kotlinx.android.synthetic.main.activity_main.*
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {

    lateinit var listePays : MutableList<Pays>
    private var pays : List<Pays_Entity>? = null
    var posi : Int = 0
    var histo:MutableList<Histo_Entity> = mutableListOf<Histo_Entity>()
    private var db: AppDB? = null
    private var dao: Pays_DAO? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //  setSupportActionBar(Toolbar)
       initDB()
           //   listePays = generateDummyList1(5) as MutableList<Pays>
            }



    fun initDB() {
        var act = this
        object : AsyncTask<Void, Void, Void>() {
            override fun doInBackground(vararg voids: Void): Void? {
                act.db = AppDB.getInstance(act)
                act.dao = db?.paysDAO()
               // var db = Room.databaseBuilder(applicationContext, AppDB::class.java, "PaysDB").build()
                Thread {
                    var pays = Pays_Entity()
                    var his = Histo_Entity()
                    var res = Ress_Entity()
                    var per = Person_Entity()
                    /**cnada**************************/
                    pays.pays_nom = "Canada"
                    pays.pays_des = "Le Canada est un pays nord-américain situé entre les États-Unis au sud et le cercle polaire au nord. Les principales villes sont Toronto, Vancouver, centre du cinéma de la côte ouest, Montréal et Québec, toutes deux francophones, et Ottawa, la capitale. Le Canada compte, parmi ses vastes étendues sauvages, le parc national de Banff avec ses nombreux lacs situé" +
                            " dans les montagnes Rocheuses. Il abrite également les célèbres et majestueuses chutes du Niagara."
                    pays.pays_slide= listOf(R.drawable.can3,R.drawable.can3,R.drawable.can4,R.drawable.can4)
                    pays.pays_video= listOf(R.raw.video2)
                    pays.pays_drap = R.drawable.drpcan
                    pays.pays_hymne=R.raw.song1
                    pays.pays_population =  "37,59 millions (2019)"
                    pays.pays_surface ="9 984 670 km2"
                    act.db!!.paysDAO().savePays(pays)
                    his.histo_date="05/01/1988"
                    his.histo_des="La guerre"
                    his.histo_paysId = 1
                    act.db!!.paysDAO().saveHis(his)
                    his.histo_date="14/11/2019"
                    his.histo_des="la liberte"
                    his.histo_paysId = 1
                    act.db!!.paysDAO().saveHis(his)
                    res.ress_paysId=1
                    res.ress_nom="le petrole"
                    res.ress_des="une reserve de petrole "
                    act.db!!.paysDAO().saveRes(res)
                    res.ress_paysId=1
                    res.ress_nom="le vent"
                    res.ress_des="une reserve de vent"
                    act.db!!.paysDAO().saveRes(res)
                    per.person_paysId =1
                    per.person_nom= "Michelle"
                    per.person_des ="le commandant"
                    act.db!!.paysDAO().savePer(per)
                    /**france***************************************/
                    pays.pays_nom = "Algerie"
                    pays.pays_des = "cest un pays de l afrique"
                    pays.pays_slide= listOf(R.drawable.alg1,R.drawable.alg2,R.drawable.alg4,R.drawable.alg3)
                    pays.pays_drap = R.drawable.algdrap2
                    pays.pays_video= listOf(R.raw.video2)
                    pays.pays_hymne=R.raw.song1
                    pays.pays_population = "22.22F"
                    pays.pays_surface = "22.22F"
                    act.db!!.paysDAO().savePays(pays)
                    his.histo_date="05/01/1988"
                    his.histo_des="La guerre de peuple"
                    his.histo_paysId = 2
                    act.db!!.paysDAO().saveHis(his)
                    his.histo_date="14/11/2019"
                    his.histo_des="la liberte"
                    his.histo_paysId = 2
                    act.db!!.paysDAO().saveHis(his)
                    res.ress_paysId=2
                    res.ress_nom="le petrole"
                    res.ress_des="une reserve de petrole "
                    act.db!!.paysDAO().saveRes(res)
                    res.ress_paysId=2
                    res.ress_nom="le vent"
                    res.ress_des="une reserve de vent"
                    act.db!!.paysDAO().saveRes(res)
                    per.person_paysId =2
                    per.person_nom= "Michelle"
                    per.person_des ="le commandant"
                    act.db!!.paysDAO().savePer(per)

                    pays.pays_nom = "Corée"
                    pays.pays_des = "cest un pays de l asie"
                    pays.pays_slide= listOf(R.drawable.co1,R.drawable.co4,R.drawable.co2,R.drawable.co3)
                    pays.pays_drap = R.drawable.coreedrap
                    pays.pays_hymne=R.raw.song1
                    pays.pays_population = "22.22F"
                    pays.pays_surface = "22.22F"
                    act.db!!.paysDAO().savePays(pays)
                    his.histo_date="05/01/1988"
                    his.histo_des="La guerre de peuple"
                    his.histo_paysId = 3
                    act.db!!.paysDAO().saveHis(his)
                    his.histo_date="14/11/2019"
                    his.histo_des="la liberte"
                    his.histo_paysId = 3
                    act.db!!.paysDAO().saveHis(his)
                    res.ress_paysId=3
                    res.ress_nom="le petrole"
                    res.ress_des="une reserve de petrole "
                    act.db!!.paysDAO().saveRes(res)
                    res.ress_paysId=3
                    res.ress_nom="le vent"
                    res.ress_des="une reserve de vent"
                    act.db!!.paysDAO().saveRes(res)
                    per.person_paysId =3
                    per.person_nom= "Michelle"
                    per.person_des ="le commandant"
                    act.db!!.paysDAO().savePer(per)

                    pays.pays_nom = "Australie"
                    pays.pays_des = "cest un pays de l aukyanie"
                    pays.pays_slide= listOf(R.drawable.aus1,R.drawable.aus2,R.drawable.aus3,R.drawable.aus4)
                    pays.pays_drap = R.drawable.ausdrap
                    pays.pays_population = "22.22F"
                    pays.pays_surface = "22.22F"
                    act.db!!.paysDAO().savePays(pays)
                    his.histo_date="05/01/1988"
                    his.histo_des="La guerre de peuple"
                    his.histo_paysId = 4
                    act.db!!.paysDAO().saveHis(his)
                    his.histo_date="14/11/2019"
                    his.histo_des="la liberte"
                    his.histo_paysId = 4
                    act.db!!.paysDAO().saveHis(his)
                    res.ress_paysId=4
                    res.ress_nom="le petrole"
                    res.ress_des="une reserve de petrole "
                    act.db!!.paysDAO().saveRes(res)
                    res.ress_paysId=4
                    res.ress_nom="le vent"
                    res.ress_des="une reserve de vent"
                    act.db!!.paysDAO().saveRes(res)
                    per.person_paysId =4
                    per.person_nom= "Michelle"
                    per.person_des ="le commandant"
                    act.db!!.paysDAO().savePer(per)

                    pays.pays_nom = "Italie"
                    pays.pays_des = "cest un pays de l europe"
                    pays.pays_slide= listOf(R.drawable.it2,R.drawable.it3,R.drawable.it4,R.drawable.ita1)
                    pays.pays_drap = R.drawable.italdrap
                    pays.pays_population = "22.22F"
                    pays.pays_surface = "22.22F"
                    act.db!!.paysDAO().savePays(pays)
                    his.histo_date="05/01/1988"
                    his.histo_des="La guerre de peuple"
                    his.histo_paysId = 5
                    act.db!!.paysDAO().saveHis(his)
                    his.histo_date="14/11/2019"
                    his.histo_des="la liberte"
                    his.histo_paysId = 5
                    act.db!!.paysDAO().saveHis(his)
                    res.ress_paysId=5
                    res.ress_nom="le petrole"
                    res.ress_des="une reserve de petrole "
                    act.db!!.paysDAO().saveRes(res)
                    res.ress_paysId=5
                    res.ress_nom="le vent"
                    res.ress_des="une reserve de vent"
                    act.db!!.paysDAO().saveRes(res)
                    per.person_paysId =5
                    per.person_nom= "Michelle"
                    per.person_des ="le commandant"
                    act.db!!.paysDAO().savePer(per)

                }.start()
                pays = act.dao?.readPays()
                val list = ArrayList<Pays>()

               // list2=act.dao!!.getPaysHisto()
                pays!!.forEach(){
                   // it.histo.forEach(){
                     //   val item = Pays(it.histo_des, R.drawable.ic_launcher_background,it.histo_date,5.5F,5.5F)
                    var list2=ArrayList<String>()
                    var list3=ArrayList<String>()
                    var list4=ArrayList<String>()
                    var listslide=ArrayList<Int>()
                    var videos=ArrayList<Int>()
                        act.dao!!.getPaysHisto(it.pays_id).forEach(){
                           it.histo.forEach(){
                               list2.add(it.histo_date + "  : \n" + it.histo_des)
                            //   list3.add(it.histo_des)
                           }
                        }
                    act.dao!!.getPaysRess(it.pays_id).forEach(){
                        it.ress.forEach(){
                            list3.add(it.ress_nom + "  : \n" + it.ress_des)
                            //   list3.add(it.histo_des)
                        }
                    }
                    act.dao!!.getPaysPerson(it.pays_id).forEach(){
                        it.person.forEach(){
                            list4.add(it.person_nom+ "  : \n" + it.person_des)
                            //   list3.add(it.histo_des)
                        }
                    }
                    it.pays_slide.forEach(){
                        listslide.add(it)
                    }
                    it.pays_video.forEach(){
                        videos.add(it)
                    }
                    val item = Pays(it.pays_nom,it.pays_drap,it.pays_des,it.pays_population,it.pays_surface,list2,list3,list4,listslide,it.pays_hymne,videos)
                    list += item
                }
                listePays=list
                return null
            }

            override fun onPostExecute(result: Void?) {
            if(listePays != null){
                //Log.i("@AKTDEV", "id is : : ${listePays[0].nom}")
                recycler_view.adapter = PaysAdapter(act,listePays)
                recycler_view.layoutManager = LinearLayoutManager(act)
                recycler_view.setHasFixedSize(true)
            }
            }

        }.execute()
    }

}
