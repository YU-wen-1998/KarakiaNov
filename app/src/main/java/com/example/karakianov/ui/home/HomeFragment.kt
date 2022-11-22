package com.example.karakianov.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.karakianov.MainActivity
import com.example.karakianov.R
import com.example.karakianov.adapter.KarakiaAdapter
import com.example.karakianov.data.FragmentLifeViewModel
import com.example.karakianov.data.KarakiaData
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(){
    private val karakiaList = generateList()
    private val viewModel: FragmentLifeViewModel = FragmentLifeViewModel() // initialize it

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        home_initial.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = KarakiaAdapter(karakiaList)
        }
        if(viewModel != null) {
            viewModel.activity = activity as MainActivity
            lifecycle.addObserver(viewModel)
        }
    }

    private fun generateList(): ArrayList<KarakiaData>{
        val karakiaStringList = ArrayList<KarakiaData>()
        karakiaStringList.add(
            KarakiaData(
                1,
                "Tōia mai",
                "Karakia Timatanga or opening prayer/incantation.\n\n" +
                        "Karakia are used to seek spiritual guidance in an effort to ensure a favourable outcome. There are many different karakia for many different situations.\n" +
                        "\n" +
                        "There may not appropriate translations for the words or metaphors.\n" +
                        "\n" +
                        "According to Wintec Te Pūkinga: “Tōia Mai is an excellence framework guiding our local response to the aims and objectives of Te Pūkenga. It delivers system-wide\n" +
                        "change, enabling Wintec to improve equitable outcomes for ākonga Mäori and all learners, and demonstrable Te Tiriti o Waitangi”\n" +
                        "(Wintec Te Pūkinga,(n.d),(para 1)).\n" +
                        "\n" +
                        "Sources:\n" +
                        "Image from: Britannica,(n.d),Māori culture in the 21st century,https://www.britannica.com/topic/Maori/Maori-culture-in-the-21st-century\n\n" +
                        "Spinpoi,(n.d),Karakia Timatanga,https://spinpoi.com/karakia\n" +
                        "Wintec Te Pūkinga,(n.d),Tōia mai excellence framework,https://wintecac.sharepoint.com/SitePages/Toia-mai.aspx\n",
                R.drawable.openingone,
                "\nDraw forward our learners\n" +
                        "Draw forward our staff\n" +
                        "Draw forward the many\n " +
                        "people from the\n" +
                        "four corners of the world\n" +
                        "Draw them forward under the mantle of\n" +
                        "love and peace\n" +
                        "\nLet us remain steadfast to these words!",
                "\nTōia mai ngā tauira\n" +
                        "Tōia mai ngā kaimahi\n" +
                        "Tōia mai ngā tāngata\n" +
                        " nō ngā hau e whā\n" +
                        "Tōia mai i runga i te aroha me te\n" +
                        "rangimārie\n" +
                        "\nKia mau, kia ita\n" +
                        "Haumi e, hui e\n" +
                        "Taiki e!\n",
                R.raw.opening1
            )
        )
        karakiaStringList.add(
            KarakiaData(
                2,
                "Whakataka te hau\n",
                "  Karakia Timatanga or opening prayer.\n\n" +
                        "Karakia are used to seek spiritual guidance in an effort to ensure a favourable outcome. There are many different karakia for many different situations.\n" +
                        "\n" +
                        "There may not appropriate translations for the words or metaphors.\n" +
                        "\n" +
                        "\n" +
                        "This Karakia is based of the final verse(stanza) of the karakia “Tua, Tua”.\n" +
                        "It tells the story of how the waka Takitimu, while exploring the south island near the Franz-Joseph glacier encountered a storm but was able to endure the harsh weather conditions due to its excellent construction and skilled seamanship.\n" +
                        "It reminds us that the forces of nature are powerful and can harm us but if we prepare for them and respond in harmony with them and our ancestors we will be rewarded with warmth and calm.\n" +
                        "\n" +
                        "Sources:\n" +
                        "Image from: \"Spinpoi,(n.d),Karakia Timatanga (Māori Opening Prayer for Poi | Learn a Karakia,https://spinpoi.com/karakia\\n\"\n" +
                        "Spinpoi,(n.d),Karakia Timatanga,https://spinpoi.com/karakia\n" +
                        "folksong.org,(2008),Whatataka te Hua, https://folksong.org.nz/whakataka_te_hau/\n",
                R.drawable.openingtwo,
                "\nThe wind swings to the west\n" +
                        "then turns into a southerly.\n" +
                        "\nmaking it prickly cold inland,\n" +
                        "and piercingly cold on the coast.\n" +
                        "\nMay the dawn rise red-tipped\n" +
                        "on ice, on snow, on frost.\n" +
                        "\nJoin! Gather! Intertwine!",
                "\nWhakataka te hau ki te uru,\n" +
                        "Whakataka te hau ki te tonga.\n" +
                        "\nKia makinakina ki uta,\n" +
                        "Kia mataratara ki tai.\n" +
                        "\nE hi ake ana te atakura\n" +
                        "he tio, he huka, he hauhunga.\n" +
                        "\nHaumi e! Hui e! Taiki e!",
                R.raw.opening2
            )
        )
        karakiaStringList.add(
            KarakiaData(
                3,
                "E te Atua\n",
                "Blessing for food or Karakia ki te kai.\n\n"+
                        "Karakia are used to seek spiritual guidance in an effort to ensure a favourable outcome. There are many different karakia for many different situations.\n" +
                        "There may not appropriate translations for the words or metaphors.\n" +
                        "\n" +
                        "This is a Christian Karakia\n" +
                        "Following the arrival of western settlers in the 1800s into the introduction of Christianity to the Maori culture many new Karakia were written to acknowledge the Christian God and Jesus Christ.\n" +
                        "\n" +
                        "\n" +
                        "Sources:\n" +
                        "Spinpoi,(n.d),Karakia Timatanga,https://spinpoi.com/karakia\n" +
                        "Te Puni Kōkiri Ministry of Māori development,(14/October/2020),He Karakia, https://www.tpk.govt.nz/en/mo-te-puni-kokiri/karakia/he-karakia\n" +
                        "University of Otago,(n.d),Karakia-prayers, https://www.otago.ac.nz/maori/world/te-reo-maori/karakia-prayers/",
                R.drawable.blessing,
                "\n\nLord God\n" +
                        "Bless this food\n" +
                        "For the goodness of our bodies\n" +
                        "Feeding our spiritual needs\n" +
                        "also with " +
                        "the bread of life\n" +
                        "\nJesus Christ, our Lord\n" +
                        "For ever and ever\n" +
                        "Amen\n",
                "\n\nE te Atua\n" +
                        "Whakapainga ēnei kai\n" +
                        "Hei oranga mō ō mātou tinana\n" +
                        "Whāngaia hoki ō mātou\n" +
                        "wairua ki te taro\n" +
                        "o te ora\n" +
                        "\nKo Ihu Karaiti tō mātou Ariki\n" +
                        "Ake, ake, ake\n" +
                        "Amine",
                R.raw.blessingforfood
            )
        )
        karakiaStringList.add(
            KarakiaData(
                4,
                "Kai tau ki\n",
                "Karakia Whakamutunga/Closing prayer.\n\n" +
                        "There may not appropriate translations for the words or metaphors.\n\n" +
                        "This is a Christian Karakia\n\n" +
                        "Following the arrival of western settlers in the 1800s into the introduction of Christianity to the Maori culture many new Karakia were written to acknowledge the Christian God and Jesus Christ.\n\n" +
                        "This is a translation of the bible passage 2 Corinthians 13:14 \n" +
                        "From the New Testament,  New International Version.\n\n" +
                        "Sources:\n" +
                        "University of Otago,(n.d),Karakia-prayers, https://www.otago.ac.nz/maori/world/te-reo-maori/karakia-prayers/\n" +
                        "Te Puni Kōkiri Ministry of Māori development,(14/October/2020),He Karakia, https://www.tpk.govt.nz/en/mo-te-puni-kokiri/karakia/he-karakia\n" +
                        "biblegateway.com,(n.d),2 Corinthians 13:14, https://www.biblegateway.com/passage/?search=2%20Corinthians+13&version=NIV\n",
                R.drawable.closingone,
                "\n\nMay the grace of the Lord\n" +
                        " Jesus Christ\n" +
                        "\nAnd the love of God and the fellowship\n" +
                        "of the Holy Spirit Be with you all\n" +
                        "\nforever and ever,\n" +
                        "Amen",
                "\n\nKia tau ki ā tātou katoa\n" +
                        "Te atawhai o tō tātou Ariki\n" +
                        "ā Ihu Karaiti\n" +
                        "\nMe te aroha o te Atua\n" +
                        "Me te whiwhinga tahitanga\n" +
                        "Ki te Wairua Tapu\n" +
                        "\nĀke, ake, ake \n" +
                        "Āmine ",
                R.raw.closing1
            )
        )
        karakiaStringList.add(
            KarakiaData(
                5,
                "He hōnore\n" ,
                "Karakia are used to seek spiritual guidance in an effort to ensure a favourable outcome. There are many different karakia for many different situations.\n" +
                        "There may not appropriate translations for the words or metaphors.\n" +
                        "\n" +
                        "This Karakia has both Biblical and Tūhoe origins.\n" +
                        "The words from Luke 2:14 were used by Ringatū church to create this karakia.\n" +
                        "During a 1992 visit to Wintec (Then Waikato Polytechnic) Ranui Ngarimu and her family sung a version of this Karakia used by the Maori language teaching organization “Te Ataarangi Inc” \n\n" +
                        "Sources:\n" +
                        "Image from: CBHS Media Team,(Sep 14, 2021),Closing Karakia,https://www.youtube.com/watch?v=ZO0Zt1xh7pw\n\n" +
                        "Spinpoi,(n.d),Karakia Timatanga,https://spinpoi.com/karakia\n" +

                        "Folksong.org,(March 2013),He hōnore, https://folksong.org.nz/he_honore/index.htm\n",
                R.drawable.closingtwo,
                "\n\n\nHonour, glory and\n" +
                        "peace to the land.\n" +
                        "May good thoughts come\n" +
                        "to all men\n\n" +
                        "for ever and ever.\n" +
                        "Amen.",
                "\n\n\nHe hōnore, he korōria\n" +
                        "Maungārongo ki te whenua.\n" +
                        "Whakaaro pai e\n" +
                        "Kingā tangata katoa\n\n" +
                        "Ake, ake, ake.\n" +
                        "Āmine\n",
                R.raw.closing2
            )
        )
        return karakiaStringList
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}