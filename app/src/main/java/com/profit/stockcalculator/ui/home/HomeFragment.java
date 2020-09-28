package com.profit.stockcalculator.ui.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.snackbar.Snackbar;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.profit.stockcalculator.MainActivity;
import com.profit.stockcalculator.R;
import com.profit.stockcalculator.SecondActivity;

import java.util.ArrayList;

public class HomeFragment extends Fragment  {
    String[] ITEMS = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6"};


    Button addition,cal;
    LinearLayout l1,l2,l3,l4,l5;
    int flag=1;
    TextView total_tt;
    String security_name="none";
    TextView rst;
    EditText t1,t2,t3;
    EditText buy1,buy2,buy3,buy4,buy5;
    EditText qt1,qt2,qt3,qt4,qt5;
    TextView tt1,tt2,tt3,tt4,tt5;
    Integer total_total_value;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        total_tt =root.findViewById(R.id.total_value);
        addition=root.findViewById(R.id.add);
        cal=root.findViewById(R.id.calculate);
        l1=root.findViewById(R.id.lin1);
        l2=root.findViewById(R.id.lin2);
        l3=root.findViewById(R.id.lin3);
        l4=root.findViewById(R.id.lin4);
        l5=root.findViewById(R.id.lin5);
        t1=root.findViewById(R.id.inputtarget1);
        t2=root.findViewById(R.id.inputtarget2);
        t3=root.findViewById(R.id.inputtarget3);
        buy1=root.findViewById(R.id.buy1);
        buy2=root.findViewById(R.id.buy2);
        buy3=root.findViewById(R.id.buy3);
        buy4=root.findViewById(R.id.buy4);
        buy5=root.findViewById(R.id.buy5);
        qt1=root.findViewById(R.id.qnty1);
        qt2=root.findViewById(R.id.qnty2);
        qt3=root.findViewById(R.id.qnty3);
        qt4=root.findViewById(R.id.qnty4);
        qt5=root.findViewById(R.id.qnty5);
        tt1 = root.findViewById(R.id.total1);
        tt2 = root.findViewById(R.id.total2);
        tt3 = root.findViewById(R.id.total3);
        tt4 = root.findViewById(R.id.total4);
        tt5 = root.findViewById(R.id.total5);
        rst =root.findViewById(R.id.reset);
        buy1.addTextChangedListener(buy1change);
        buy2.addTextChangedListener(buy2change);
        buy3.addTextChangedListener(buy3change);
        buy4.addTextChangedListener(buy4change);
        buy5.addTextChangedListener(buy5change);
        qt1.addTextChangedListener(q1change);
        qt2.addTextChangedListener(q2change);
        qt3.addTextChangedListener(q3change);
        qt4.addTextChangedListener(q4change);
        qt5.addTextChangedListener(q5change);

        tt1.setText("0");
        tt2.setText("0");
        tt3.setText("0");
        tt4.setText("0");
        tt5.setText("0");
        total_tt.setText("0");
rst.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        l1.setVisibility(View.VISIBLE);
        l2.setVisibility(View.GONE);
        l3.setVisibility(View.GONE);
        l4.setVisibility(View.GONE);
        l5.setVisibility(View.GONE);
        buy1.setText("");
        qt1.setText("");
        tt1.setText("0");
        total_tt.setText("0");
    }
});

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = t1.getText().toString();
                String text2 = t2.getText().toString();
                String text3 =t3.getText().toString();
                String intent_buy1 = buy1.getText().toString();
                String intent_buy2 = buy2.getText().toString();
                String intent_buy3 = buy3.getText().toString();
                String intent_buy4 = buy4.getText().toString();
                String intent_buy5 = buy5.getText().toString();
                String intent_qt1 = qt1.getText().toString();
                String intent_qt2 = qt2.getText().toString();
                String intent_qt3 = qt3.getText().toString();
                String intent_qt4 = qt4.getText().toString();
                String intent_qt5 = qt5.getText().toString();
                String intent_total1 = tt1.getText().toString();
                String intent_total2 = tt2.getText().toString();
                String intent_total3 = tt3.getText().toString();
                String intent_total4 = tt4.getText().toString();
                String intent_total5 = tt5.getText().toString();
                String intent_total_total_value = total_tt.getText().toString();
                if(text1.matches("")&&text2.matches("")&&text3.matches(""))
                {
                    Toast.makeText(getContext(),"Enter Estimated  Target Values",Toast.LENGTH_LONG).show();
                }
               else if(security_name.equals("none"))
                {
                    Toast.makeText(getContext(),"Select Security Name",Toast.LENGTH_LONG).show();
                }

                else if(intent_buy1.matches("")&&intent_buy2.matches("")&&intent_buy3.matches("")&&intent_buy4.matches("")&&intent_buy5.matches(""))
                {
                    Toast.makeText(getContext(),"Enter atleast one investment",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Intent next = new Intent(getContext(), SecondActivity.class);
                    Bundle bundle =new Bundle();
                    bundle.putString("intent_buy1",intent_buy1);
                    bundle.putString("intent_buy2",intent_buy2);
                    bundle.putString("intent_buy3",intent_buy3);
                    bundle.putString("intent_buy4",intent_buy4);
                    bundle.putString("intent_buy5",intent_buy5);
                    bundle.putString("intent_qt1",intent_qt1);
                    bundle.putString("intent_qt2",intent_qt2);
                    bundle.putString("intent_qt3",intent_qt3);
                    bundle.putString("intent_qt4",intent_qt4);
                    bundle.putString("intent_qt5",intent_qt5);
                    bundle.putString("intent_tt1",intent_total1);
                    bundle.putString("intent_tt2",intent_total2);
                    bundle.putString("intent_tt3",intent_total3);
                    bundle.putString("intent_tt4",intent_total4);
                    bundle.putString("intent_tt5",intent_total5);
                    bundle.putString("intent_total_total_value",intent_total_total_value);
                    bundle.putString("security_name",security_name);
                    bundle.putString("intent_t1",text1);
                    bundle.putString("intent_t2",text2);
                    bundle.putString("intent_t3",text3);
                    next.putExtras(bundle);
                    startActivity(next);
                }

            }
        });
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=flag+1;
                if(flag==2)
                {
                    l2.setVisibility(View.VISIBLE);
                }
                if(flag==3)
                {
                    l3.setVisibility(View.VISIBLE);
                }
                if(flag==4)
                {
                    l4.setVisibility(View.VISIBLE);
                }
                if(flag==5)
                {
                    l5.setVisibility(View.VISIBLE);
                }
            }
        });
        MaterialSpinner spinner = root.findViewById(R.id.spinner1);
        spinner.setItems("SELECT SECURITY",
                "1025GS2021",
                "20MICRONS",
                "21STCENMGM",
                "3IINFOTECH",
                "3MINDIA",
                "5PAISA",
                "63MOONS",
                "716GS2050",
                "719GS2060",
                "762GS2039",
                "769GS2043",
                "A2ZINFRA",
                "AAKASH",
                "AARON",
                "AARTIDRUGS",
                "AARTIIND",
                "AARTISURF",
                "AARVEEDEN",
                "AARVI",
                "AAVAS",
                "ABAN",
                "ABB",
                "ABBOTINDIA",
                "ABCAPITAL",
                "ABFRL",
                "ABFRLPP",
                "ABMINTLTD",
                "ABSLBANETF",
                "ABSLNN50ET",
                "ACC",
                "ACCELYA",
                "ACCURACY",
                "ACE",
                "ADANIENT",
                "ADANIGAS",
                "ADANIGREEN",
                "ADANIPORTS",
                "ADANIPOWER",
                "ADANITRANS",
                "ADFFOODS",
                "ADHUNIKIND",
                "ADORWELD",
                "ADROITINFO",
                "ADSL",
                "ADVANIHOTR",
                "ADVENZYMES",
                "AEGISCHEM",
                "AFFLE",
                "AGARIND",
                "AGCNET",
                "AGRITECH",
                "AGROPHOS",
                "AHLADA",
                "AHLEAST",
                "AHLUCONT",
                "AHLWEST",
                "AIAENG",
                "AIONJSW",
                "AIRAN",
                "AIROLAM",
                "AJANTPHARM",
                "AJMERA",
                "AJOONI",
                "AKASH",
                "AKSHARCHEM",
                "AKSHOPTFBR",
                "AKZOINDIA",
                "ALANKIT",
                "ALBERTDAVD",
                "ALCHEM",
                "ALEMBICLTD",
                "ALICON",
                "ALKALI",
                "ALKEM",
                "ALKYLAMINE",
                "ALLCARGO",
                "ALLSEC",
                "ALMONDZ",
                "ALOKINDS",
                "ALPA",
                "ALPHAGEO",
                "ALPSINDUS",
                "AMARAJABAT",
                "AMBER",
                "AMBIKCO",
                "AMBUJACEM",
                "AMDIND",
                "AMJLAND",
                "AMRUTANJAN",
                "ANANTRAJ",
                "ANDHRACEMT",
                "ANDHRAPAP",
                "ANDHRSUGAR",
                "ANIKINDS",
                "ANKITMETAL",
                "ANSALAPI",
                "ANSALHSG",
                "ANUP",
                "APARINDS",
                "APCL",
                "APCOTEXIND",
                "APEX",
                "APLAPOLLO",
                "APLLTD",
                "APOLLO",
                "APOLLOHOSP",
                "APOLLOPIPE",
                "APOLLOTYRE",
                "APOLSINHOT",
                "APTECHT",
                "ARCHIDPLY",
                "ARCHIES",
                "ARCOTECH",
                "ARENTERP",
                "ARIES",
                "ARIHANT",
                "ARIHANTSUP",
                "ARMANFIN",
                "AROGRANITE",
                "ARROWGREEN",
                "ARSHIYA",
                "ARSSINFRA",
                "ARTEMISMED",
                "ARVIND",
                "ARVINDFASN",
                "ARVSMART",
                "ASAHIINDIA",
                "ASAHISONG",
                "ASAL",
                "ASALCBR",
                "ASHAPURMIN",
                "ASHIANA",
                "ASHIMASYN",
                "ASHOKA",
                "ASHOKLEY",
                "ASIANHOTNR",
                "ASIANPAINT",
                "ASIANTILES",
                "ASPINWALL",
                "ASTEC",
                "ASTERDM",
                "ASTRAL",
                "ASTRAMICRO",
                "ASTRAZEN",
                "ASTRON",
                "ATFL",
                "ATLANTA",
                "ATLASCYCLE",
                "ATUL",
                "ATULAUTO",
                "AUBANK",
                "AURIONPRO",
                "AUROPHARMA",
                "AUSOMENT",
                "AUTOAXLES",
                "AUTOIND",
                "AUTOLITIND",
                "AVADHSUGAR",
                "AVANTIFEED",
                "AVTNPL",
                "AXISBANK",
                "AXISCADES",
                "AXISGOLD",
                "AXISNIFTY",
                "AYMSYNTEX",
                "BAGFILMS",
                "BAJAJ-AUTO",
                "BAJAJCON",
                "BAJAJELEC",
                "BAJAJFINSV",
                "BAJAJHIND",
                "BAJAJHLDNG",
                "BAJFINANCE",
                "BALAJITELE",
                "BALAMINES",
                "BALAXI",
                "BALKRISHNA",
                "BALKRISIND",
                "BALLARPUR",
                "BALMLAWRIE",
                "BALPHARMA",
                "BALRAMCHIN",
                "BANARBEADS",
                "BANARISUG",
                "BANCOINDIA",
                "BANDHANBNK",
                "BANG",
                "BANKA",
                "BANKBARODA",
                "BANKBEES",
                "BANKINDIA",
                "BANSWRAS",
                "BARTRONICS",
                "BASF",
                "BASML",
                "BATAINDIA",
                "BAYERCROP",
                "BBL",
                "BBTC",
                "BCG",
                "BCP",
                "BDL",
                "BEARDSELL",
                "BEDMUTHA",
                "BEL",
                "BEML",
                "BEPL",
                "BERGEPAINT",
                "BETA",
                "BFINVEST",
                "BFUTILITIE",
                "BGRENERGY",
                "BHAGERIA",
                "BHAGYANGR",
                "BHAGYAPROP",
                "BHANDARI",
                "BHARATFORG",
                "BHARATGEAR",
                "BHARATRAS",
                "BHARATWIRE",
                "BHARTIARTL",
                "BHEL",
                "BIGBLOC",
                "BIL",
                "BILENERGY",
                "BINDALAGRO",
                "BIOCON",
                "BIOFILCHEM",
                "BIRLACABLE",
                "BIRLACORPN",
                "BIRLAMONEY",
                "BIRLATYRE",
                "BKMINDST",
                "BLBLIMITED",
                "BLISSGVS",
                "BLKASHYAP",
                "BLS",
                "BLUEDART",
                "BLUESTARCO",
                "BODALCHEM",
                "BOMDYEING",
                "BOROLTD",
                "BORORENEW",
                "BOSCHLTD",
                "BPCL",
                "BPL",
                "BRFL",
                "BRIGADE",
                "BRIGHT",
                "BRITANNIA",
                "BRITANNIA",
                "BRNL",
                "BROOKS",
                "BSE",
                "BSELINFRA",
                "BSHSL",
                "BSL",
                "BSLGOLDETF",
                "BSLNIFTY",
                "BSOFT",
                "BURNPUR",
                "BUTTERFLY",
                "BVCL",
                "BYKE",
                "CADILAHC",
                "CALSOFT",
                "CAMLINFINE",
                "CANBK",
                "CANDC",
                "CANFINHOME",
                "CANTABIL",
                "CAPACITE",
                "CAPLIPOINT",
                "CAPTRUST",
                "CARBORUNIV",
                "CAREERP",
                "CARERATING",
                "CASTROLIND",
                "CCHHL",
                "CCL",
                "CDSL",
                "CEATLTD",
                "CEBBCO",
                "CELEBRITY",
                "CENTENKA",
                "CENTEXT",
                "CENTRALBK",
                "CENTRUM",
                "CENTUM",
                "CENTURYPLY",
                "CENTURYTEX",
                "CERA",
                "CEREBRAINT",
                "CESC",
                "CESCVENT",
                "CGCL",
                "CGPOWER",
                "CHALET",
                "CHAMBLFERT",
                "CHEMBOND",
                "CHEMFAB",
                "CHENNPETRO",
                "CHOLAFIN",
                "CHOLAHLDNG",
                "CHROMATIC",
                "CIGNITITEC",
                "CIMMCO",
                "CINELINE",
                "CINEVISTA",
                "CIPLA",
                "CKFSL",
                "CKPLEISURE",
                "CLEDUCATE",
                "CLNINDIA",
                "CMICABLES",
                "CMMIPL",
                "CNOVAPETRO",
                "COALINDIA",
                "COCHINSHIP",
                "COFORGE",
                "COLPAL",
                "COMPINFO",
                "COMPUSOFT",
                "CONCOR",
                "CONFIPET",
                "CONSOFINVT",
                "CONTI",
                "CONTROLPR",
                "CORALFINAC",
                "CORDSCABLE",
                "COROMANDEL",
                "COSMOFILMS",
                "COUNCODOS",
                "COX&KINGS",
                "CPSEETF",
                "CREATIVE",
                "CREATIVEYE",
                "CREDITACC",
                "CREST",
                "CRISIL",
                "CROMPTON",
                "CSBBANK",
                "CTE",
                "CUB",
                "CUBEXTUB",
                "CUMMINSIND",
                "CUPID",
                "CYBERTECH",
                "CYIENT",
                "DAAWAT",
                "DABUR",
                "DALBHARAT",
                "DALMIASUG",
                "DAMODARIND",
                "DATAMATICS",
                "DBCORP",
                "DBL",
                "DBREALTY",
                "DBSTOCKBRO",
                "DCAL",
                "DCBBANK",
                "DCM",
                "DCMFINSERV",
                "DCMNVL",
                "DCMSHRIRAM",
                "DCW",
                "DECCANCE",
                "DEEPAKFERT",
                "DEEPAKNTR",
                "DEEPIND",
                "DELTACORP",
                "DELTAMAGNT",
                "DEN",
                "DENORA",
                "DFMFOODS",
                "DGCONTENT",
                "DHAMPURSUG",
                "DHANBANK",
                "DHANUKA",
                "DHARSUGAR",
                "DHFL",
                "DHFL",
                "DHFL",
                "DHFL",
                "DHFL",
                "DHFL",
                "DHFL",
                "DHFL",
                "DHUNINV",
                "DIAMONDYD",
                "DIAPOWER",
                "DICIND",
                "DIGISPICE",
                "DIGJAMLTD",
                "DISHTV",
                "DIVISLAB",
                "DIXON",
                "DLF",
                "DLINKINDIA",
                "DMART",
                "DNAMEDIA",
                "DOLAT",
                "DOLLAR",
                "DONEAR",
                "DPABHUSHAN",
                "DPSCLTD",
                "DPWIRES",
                "DQE",
                "DREDGECORP",
                "DRREDDY",
                "DRSDILIP",
                "DSML",
                "DSSL",
                "DTIL",
                "DUCON",
                "DVL",
                "DWARKESH",
                "DYNAMATECH",
                "DYNPRO",
                "EASTSILK",
                "EASUNREYRL",
                "EBBETF0423",
                "EBBETF0425",
                "EBBETF0430",
                "EBBETF0431",
                "EBIXFOREX",
                "ECLERX",
                "ECLFINANCE",
                "ECLFINANCE",
                "ECLFINANCE",
                "ECLFINANCE",
                "ECLFINANCE",
                "ECLFINANCE",
                "ECLFINANCE",
                "ECLFINANCE",
                "ECLFINANCE",
                "ECLFINANCE",
                "ECLFINANCE",
                "EDELWEISS",
                "EDUCOMP",
                "EHFLNCD",
                "EHFLNCD",
                "EHFLNCD",
                "EICHERMOT",
                "EIDPARRY",
                "EIFFL",
                "EIHAHOTELS",
                "EIHOTEL",
                "EIMCOELECO",
                "EKC",
                "ELECON",
                "ELECTCAST",
                "ELECTHERM",
                "ELGIEQUIP",
                "ELGIRUBCO",
                "EMAMILTD",
                "EMAMIPAP",
                "EMAMIREAL",
                "EMBASSY",
                "EMCO",
                "EMKAY",
                "EMMBI",
                "EMOFSR1RDP",
                "EMOFSR1RGG",
                "ENDURANCE",
                "ENERGYDEV",
                "ENGINERSIN",
                "ENIL",
                "EQ30",
                "EQUITAS",
                "ERFLNCDI",
                "ERFLNCDI",
                "ERFLNCDI",
                "ERIS",
                "EROSMEDIA",
                "ESABINDIA",
                "ESCORTS",
                "ESSARSHPNG",
                "ESSELPACK",
                "ESTER",
                "EUROCERA",
                "EUROMULTI",
                "EUROTEXIND",
                "EVEREADY",
                "EVERESTIND",
                "EXCEL",
                "EXCELINDUS",
                "EXIDEIND",
                "EXPLEOSOL",
                "FACT",
                "FAIRCHEM",
                "FCL",
                "FCONSUMER",
                "FCSSOFT",
                "FDC",
                "FEDERALBNK",
                "FEL",
                "FELDVR",
                "FIEMIND",
                "FILATEX",
                "FILDF2GP",
                "FINCABLES",
                "FINEORG",
                "FINPIPE",
                "FLEXITUFF",
                "FLFL",
                "FLUOROCHEM",
                "FMGOETZE",
                "FMNL",
                "FORCEMOT",
                "FORTIS",
                "FOSECOIND",
                "FOURTHDIM",
                "FRETAIL",
                "FSC",
                "FSL",
                "GABRIEL",
                "GAEL",
                "GAIL",
                "GAL",
                "GALAXYSURF",
                "GALLANTT",
                "GALLISPAT",
                "GAMMNINFRA",
                "GANDHITUBE",
                "GANECOS",
                "GANESHHOUC",
                "GANGESSECU",
                "GARDENSILK",
                "GARFIBRES",
                "GATI",
                "GAYAHWS",
                "GAYAPROJ",
                "GDL",
                "GEECEE",
                "GEEKAYWIRE",
                "GENESYS",
                "GENUSPAPER",
                "GENUSPOWER",
                "GEOJITFSL",
                "GEPIL",
                "GESHIP",
                "GET&D",
                "GFLLIMITED",
                "GFSTEELS",
                "GHCL",
                "GICHSGFIN",
                "GICRE",
                "GILLANDERS",
                "GILLETTE",
                "GINNIFILA",
                "GIPCL",
                "GKWLIMITED",
                "GLAXO",
                "GLENMARK",
                "GLFL",
                "GLOBALVECT",
                "GLOBOFFS",
                "GLOBUSSPR",
                "GMBREW",
                "GMDCLTD",
                "GMMPFAUDLR",
                "GMRINFRA",
                "GNA",
                "GNFC",
                "GOACARBON",
                "GOCLCORP",
                "GODFRYPHLP",
                "GODHA",
                "GODREJAGRO",
                "GODREJCP",
                "GODREJIND",
                "GODREJPROP",
                "GOENKA",
                "GOKEX",
                "GOKUL",
                "GOKULAGRO",
                "GOLDBEES",
                "GOLDENTOBC",
                "GOLDIAM",
                "GOLDSHARE",
                "GOLDTECH",
                "GOODLUCK",
                "GPIL",
                "GPPL",
                "GPTINFRA",
                "GRANULES",
                "GRAPHITE",
                "GRASIM",
                "GRAVITA",
                "GREAVESCOT",
                "GREENLAM",
                "GREENPANEL",
                "GREENPLY",
                "GREENPOWER",
                "GRINDWELL",
                "GROBTEA",
                "GRPLTD",
                "GRSE",
                "GSCLCEMENT",
                "GSFC",
                "GSPL",
                "GSS",
                "GTLINFRA",
                "GTNIND",
                "GTPL",
                "GUFICBIO",
                "GUJALKALI",
                "GUJAPOLLO",
                "GUJGASLTD",
                "GUJRAFFIA",
                "GULFOILLUB",
                "GULFPETRO",
                "GULPOLY",
                "GVKPIL",
                "HAL",
                "HARITASEAT",
                "HARRMALAYA",
                "HATHWAY",
                "HATSUN",
                "HAVELLS",
                "HAVISHA",
                "HBANKETF",
                "HBLPOWER",
                "HBSL",
                "HCC",
                "HCG",
                "HCL-INSYS",
                "HCLTECH",
                "HDFC",
                "HDFC",
                "HDFCAMC",
                "HDFCBANK",
                "HDFCLIFE",
                "HDFCMFGETF",
                "HDFCNIFETF",
                "HDFCSENETF",
                "HDIL",
                "HEG",
                "HEIDELBERG",
                "HERCULES",
                "HERITGFOOD",
                "HEROMOTOCO",
                "HESTERBIO",
                "HEXATRADEX",
                "HEXAWARE",
                "HFCL",
                "HGINFRA",
                "HGS",
                "HHOF1140RG",
                "HIKAL",
                "HIL",
                "HILTON",
                "HIMATSEIDE",
                "HINDALCO",
                "HINDCOMPOS",
                "HINDCOPPER",
                "HINDMOTORS",
                "HINDNATGLS",
                "HINDOILEXP",
                "HINDPETRO",
                "HINDUNILVR",
                "HINDZINC",
                "HIRECT",
                "HISARMETAL",
                "HITECH",
                "HITECHCORP",
                "HITECHGEAR",
                "HLVLTD",
                "HMT",
                "HMVL",
                "HNDFDS",
                "HNGSNGBEES",
                "HONAUT",
                "HONDAPOWER",
                "HOTELRUGBY",
                "HOVS",
                "HPL",
                "HSCL",
                "HSIL",
                "HTMEDIA",
                "HUBTOWN",
                "HUDCO",
                "HUDCO",
                "HUDCO",
                "HUDCO",
                "HUDCO",
                "HUDCO",
                "IBMFNIFTY",
                "IBREALEST",
                "IBUCCREDIT",
                "IBUCCREDIT",
                "IBUCCREDIT",
                "IBUCCREDIT",
                "IBUCCREDIT",
                "IBULHSGFIN",
                "IBULHSGFIN",
                "IBULHSGFIN",
                "IBULHSGFIN",
                "IBULISL",
                "IBVENTPP",
                "IBVENTURES",
                "ICEMAKE",
                "ICFL",
                "ICFL",
                "ICFL",
                "ICICI500",
                "ICICIALPLV",
                "ICICIB22",
                "ICICIBANK",
                "ICICIBANKN",
                "ICICIBANKP",
                "ICICIGI",
                "ICICIGOLD",
                "ICICILIQ",
                "ICICILOVOL",
                "ICICIM150",
                "ICICIMCAP",
                "ICICINF100",
                "ICICINIFTY",
                "ICICINV20",
                "ICICINXT50",
                "ICICIPRULI",
                "ICICISENSX",
                "ICICITECH",
                "ICIL",
                "ICRA",
                "IDBI",
                "IDBIGOLD",
                "IDEA",
                "IDFC",
                "IDFCFIRSTB",
                "IDFCFIRSTB",
                "IDFCFIRSTB",
                "IDFCFIRSTB",
                "IDFCFIRSTB",
                "IDFCFIRSTB",
                "IDFNIFTYET",
                "IEX",
                "IFBAGRO",
                "IFBIND",
                "IFCI",
                "IFCI",
                "IFGLEXPOR",
                "IGARASHI",
                "IGL",
                "IGPL",
                "IIFCL",
                "IIFL",
                "IIFL",
                "IIFL",
                "IIFL",
                "IIFL",
                "IIFL",
                "IIFL",
                "IIFL",
                "IIFL",
                "IIFLSEC",
                "IIFLWAM",
                "IITL",
                "IL&FSENGG",
                "IL&FSTRANS",
                "IMAGICAA",
                "IMFA",
                "IMPAL",
                "IMPEXFERRO",
                "INDBANK",
                "INDHOTEL",
                "INDIACEM",
                "INDIAGLYCO",
                "INDIAMART",
                "INDIANB",
                "INDIANCARD",
                "INDIANHUME",
                "INDIGO",
                "INDIGRID",
                "INDLMETER",
                "INDNIPPON",
                "INDOCO",
                "INDORAMA",
                "INDOSOLAR",
                "INDOSTAR",
                "INDOTECH",
                "INDOTHAI",
                "INDOWIND",
                "INDRAMEDCO",
                "INDSWFTLAB",
                "INDSWFTLTD",
                "INDTERRAIN",
                "INDUSINDBK",
                "INEOSSTYRO",
                "INFIBEAM",
                "INFOBEAN",
                "INFRABEES",
                "INFRATEL",
                "INFY",
                "INGERRAND",
                "INNOVANA",
                "INOXLEISUR",
                "INOXWIND",
                "INSECTICID",
                "INSPIRISYS",
                "INTELLECT",
                "INTENTECH",
                "INVENTURE",
                "IOB",
                "IOC",
                "IOLCP",
                "IPCALAB",
                "IRB",
                "IRBINVIT",
                "IRCON",
                "IRCTC",
                "IREDA",
                "IREDA",
                "IREDA",
                "IRFC",
                "IRFC",
                "IRFC",
                "IRFC",
                "IRFC",
                "IRFC",
                "IRFC",
                "IRFC",
                "IRFC",
                "ISEC",
                "ISFT",
                "ISMTLTD",
                "ITC",
                "ITDC",
                "ITDCEM",
                "ITI",
                "IVC",
                "IVP",
                "IVZINGOLD",
                "IVZINNIFTY",
                "IZMO",
                "J&KBANK",
                "JAGRAN",
                "JAGSNPHARM",
                "JAIBALAJI",
                "JAICORPLTD",
                "JAIHINDPRO",
                "JAINSTUDIO",
                "JAKHARIA",
                "JAMNAAUTO",
                "JASH",
                "JAYAGROGN",
                "JAYBARMARU",
                "JAYNECOIND",
                "JAYSREETEA",
                "JBCHEPHARM",
                "JBFIND",
                "JBMA",
                "JCHAC",
                "JETAIRWAYS",
                "JHS",
                "JINDALPHOT",
                "JINDALPOLY",
                "JINDALSAW",
                "JINDALSTEL",
                "JINDRILL",
                "JINDWORLD",
                "JISLDVREQS",
                "JISLJALEQS",
                "JITFINFRA",
                "JIYAECO",
                "JKCEMENT",
                "JKIL",
                "JKLAKSHMI",
                "JKPAPER",
                "JKTYRE",
                "JMA",
                "JMCPROJECT",
                "JMFINANCIL",
                "JMTAUTOLTD",
                "JOCIL",
                "JPASSOCIAT",
                "JPINFRATEC",
                "JPOLYINVST",
                "JPPOWER",
                "JSL",
                "JSLHISAR",
                "JSWENERGY",
                "JSWHL",
                "JSWSTEEL",
                "JTEKTINDIA",
                "JUBILANT",
                "JUBLFOOD",
                "JUBLINDS",
                "JUMPNET",
                "JUNIORBEES",
                "JUSTDIAL",
                "JVLAGRO",
                "JYOTHYLAB",
                "KABRAEXTRU",
                "KAJARIACER",
                "KAKATCEM",
                "KALPATPOWR",
                "KALYANIFRG",
                "KAMATHOTEL",
                "KAMDHENU",
                "KANANIIND",
                "KANORICHEM",
                "KANSAINER",
                "KAPSTON",
                "KARDA",
                "KARMAENG",
                "KARURVYSYA",
                "KAUSHALYA",
                "KAYA",
                "KCP",
                "KCPSUGIND",
                "KDDL",
                "KEC",
                "KECL",
                "KEI",
                "KELLTONTEC",
                "KENNAMET",
                "KERNEX",
                "KESORAMIND",
                "KEYFINSERV",
                "KGL",
                "KHADIM",
                "KHANDSE",
                "KICL",
                "KILITCH",
                "KINGFA",
                "KIOCL",
                "KIRIINDUS",
                "KIRLFER",
                "KIRLOSBROS",
                "KIRLOSENG",
                "KIRLOSIND",
                "KITEX",
                "KKCL",
                "KMSUGAR",
                "KNRCON",
                "KOHINOOR",
                "KOKUYOCMLN",
                "KOLTEPATIL",
                "KOPRAN",
                "KOTAKBANK",
                "KOTAKBKETF",
                "KOTAKGOLD",
                "KOTAKNIFTY",
                "KOTAKNV20",
                "KOTAKPSUBK",
                "KOTARISUG",
                "KOTHARIPET",
                "KOTHARIPRO",
                "KPITTECH",
                "KPRMILL",
                "KRBL",
                "KREBSBIO",
                "KRIDHANINF",
                "KRISHANA",
                "KSB",
                "KSCL",
                "KSERASERA",
                "KSK",
                "KSL",
                "KSOLVES",
                "KTKBANK",
                "KUANTUM",
                "KWALITY",
                "L&TFH",
                "L&TFINANCE",
                "L&TFINANCE",
                "L&TFINANCE",
                "L&TFINANCE",
                "L&TFINANCE",
                "L&TFINANCE",
                "L&TFINANCE",
                "L&TFINANCE",
                "L&TFINANCE",
                "L&TFINANCE",
                "L&TINFRA",
                "L&TINFRA",
                "L&TINFRA",
                "L&TINFRA",
                "L&TINFRA",
                "LAGNAM",
                "LAKPRE",
                "LAKSHVILAS",
                "LALPATHLAB",
                "LAMBODHARA",
                "LAOPALA",
                "LASA",
                "LAURUSLABS",
                "LAXMICOT",
                "LAXMIMACH",
                "LEMONTREE",
                "LEXUS",
                "LFIC",
                "LGBBROSLTD",
                "LGBFORGE",
                "LIBAS",
                "LIBERTSHOE",
                "LICHSGFIN",
                "LICNETFGSC",
                "LICNETFN50",
                "LICNETFSEN",
                "LICNFNHGP",
                "LINCOLN",
                "LINCPEN",
                "LINDEINDIA",
                "LIQUIDBEES",
                "LIQUIDETF",
                "LOKESHMACH",
                "LOTUSEYE",
                "LOVABLE",
                "LPDC",
                "LSIL",
                "LT",
                "LTI",
                "LTTS",
                "LUMAXIND",
                "LUMAXTECH",
                "LUPIN",
                "LUXIND",
                "LYKALABS",
                "LYPSAGEMS",
                "M&M",
                "M&MFIN",
                "M&MFIN",
                "M100",
                "M50",
                "MAANALU",
                "MACPOWER",
                "MADHAV",
                "MADHUCON",
                "MADRASFERT",
                "MAGADSUGAR",
                "MAGMA",
                "MAGNUM",
                "MAHABANK",
                "MAHAPEXLTD",
                "MAHASTEEL",
                "MAHEPC",
                "MAHESHWARI",
                "MAHINDCIE",
                "MAHLIFE",
                "MAHLOG",
                "MAHSCOOTER",
                "MAHSEAMLES",
                "MAITHANALL",
                "MAJESCO",
                "MALUPAPER",
                "MAN50ETF",
                "MANAKALUCO",
                "MANAKCOAT",
                "MANAKSIA",
                "MANAKSTEEL",
                "MANALIPETC",
                "MANAPPURAM",
                "MANGALAM",
                "MANGCHEFER",
                "MANGLMCEM",
                "MANGTIMBER",
                "MANINDS",
                "MANINFRA",
                "MANUGRAPH",
                "MANXT50",
                "MARALOVER",
                "MARATHON",
                "MARICO",
                "MARINE",
                "MARKSANS",
                "MARSHALL",
                "MARUTI",
                "MASFIN",
                "MASTEK",
                "MATRIMONY",
                "MAWANASUG",
                "MAXHEALTH",
                "MAXIND",
                "MAXVIL",
                "MAYURUNIQ",
                "MAZDA",
                "MBAPL",
                "MBECL",
                "MBLINFRA",
                "MC1RG",
                "MCDHOLDING",
                "MCDOWELL-N",
                "MCL",
                "MCLEODRUSS",
                "MCX",
                "MDL",
                "MEGASOFT",
                "MEGH",
                "MELSTAR",
                "MENONBE",
                "MEP",
                "MERCATOR",
                "METALFORGE",
                "METKORE",
                "METROPOLIS",
                "MFSL",
                "MGEL",
                "MGL",
                "MHRIL",
                "MIC",
                "MIDHANI",
                "MILTON",
                "MINDA-RE",
                "MINDACORP",
                "MINDAIND",
                "MINDSPACE",
                "MINDTECK",
                "MINDTREE",
                "MIRCELECTR",
                "MIRZAINT",
                "MITTAL",
                "MMFL",
                "MMP",
                "MMTC",
                "MODIRUBBER",
                "MOHOTAIND",
                "MOIL",
                "MOLDTECH",
                "MOLDTKPAC",
                "MONTECARLO",
                "MORARJEE",
                "MOREPENLAB",
                "MOTHERSUMI",
                "MOTILALOFS",
                "MOTOGENFIN",
                "MPHASIS",
                "MPSLTD",
                "MRF",
                "MRO-TEK",
                "MRPL",
                "MSPL",
                "MSTCLTD",
                "MTEDUCARE",
                "MTNL",
                "MUKANDENGG",
                "MUKANDLTD",
                "MUKTAARTS",
                "MUNJALAU",
                "MUNJALSHOW",
                "MURUDCERA",
                "MUTHOOTCAP",
                "MUTHOOTFIN",
                "N100",
                "NABARD",
                "NABARD",
                "NACLIND",
                "NAGAFERT",
                "NAGREEKEXP",
                "NAHARCAP",
                "NAHARINDUS",
                "NAHARPOLY",
                "NAHARSPING",
                "NAM-INDIA",
                "NANDANI",
                "NATCOPHARM",
                "NATHBIOGEN",
                "NATIONALUM",
                "NATNLSTEEL",
                "NAUKRI",
                "NAVINFLUOR",
                "NAVKARCORP",
                "NAVNETEDUL",
                "NBCC",
                "NBIFIN",
                "NBVENTURES",
                "NCC",
                "NCLIND",
                "NDGL",
                "NDL",
                "NDRAUTO",
                "NDTV",
                "NECCLTD",
                "NECLIFE",
                "NELCAST",
                "NELCO",
                "NEOGEN",
                "NESCO",
                "NESTLEIND",
                "NETF",
                "NETFCONSUM",
                "NETFDIVOPP",
                "NETFIT",
                "NETFLTGILT",
                "NETFMID150",
                "NETFNIF100",
                "NETFNV20",
                "NETWORK18",
                "NEULANDLAB",
                "NEWGEN",
                "NEXTMEDIA",
                "NFL",
                "NH",
                "NHAI",
                "NHAI",
                "NHAI",
                "NHAI",
                "NHAI",
                "NHAI",
                "NHAI",
                "NHBTF2014",
                "NHBTF2023",
                "NHPC",
                "NIACL",
                "NIBL",
                "NIFTYBEES",
                "NIFTYEES",
                "NIITLTD",
                "NILAINFRA",
                "NILASPACES",
                "NILKAMAL",
                "NIPPOBATRY",
                "NITCO",
                "NITINFIRE",
                "NITINSPIN",
                "NKIND",
                "NLCINDIA",
                "NMDC",
                "NOCIL",
                "NOIDATOLL",
                "NORBTEAEXP",
                "NPBET",
                "NRAIL",
                "NRBBEARING",
                "NSIL",
                "NTL",
                "NTPC",
                "NTPC",
                "NTPC",
                "NTPC",
                "NUCLEUS",
                "NXTDIGITAL",
                "OAL",
                "OBEROIRLTY",
                "OCCL",
                "OFSS",
                "OIL",
                "OILCOUNTUB",
                "OISL",
                "OLECTRA",
                "OMAXAUTO",
                "OMAXE",
                "OMFURN",
                "OMKARCHEM",
                "OMMETALS",
                "ONELIFECAP",
                "ONEPOINT",
                "ONGC",
                "ONMOBILE",
                "ONWARDTEC",
                "OPTIEMUS",
                "OPTOCIRCUI",
                "ORBTEXP",
                "ORICONENT",
                "ORIENTABRA",
                "ORIENTALTL",
                "ORIENTBELL",
                "ORIENTCEM",
                "ORIENTELEC",
                "ORIENTHOT",
                "ORIENTLTD",
                "ORIENTPPR",
                "ORIENTREF",
                "ORISSAMINE",
                "ORTEL",
                "ORTINLABSS",
                "OSIAHYPER",
                "OSWALAGRO",
                "OSWALSEEDS",
                "PAGEIND",
                "PAISALO",
                "PALASHSECU",
                "PALREDTEC",
                "PANACEABIO",
                "PANACHE",
                "PANAMAPET",
                "PAPERPROD",
                "PARABDRUGS",
                "PARACABLES",
                "PARAGMILK",
                "PARSVNATH",
                "PATELENG",
                "PATINTLOG",
                "PATSPINLTD",
                "PCJEWELLER",
                "PDMJEPAPER",
                "PDSMFL",
                "PEARLPOLY",
                "PEL",
                "PENIND",
                "PENINLAND",
                "PENTAGOLD",
                "PERSISTENT",
                "PETRONET",
                "PFC",
                "PFC",
                "PFC",
                "PFC",
                "PFIZER",
                "PFOCUS",
                "PFS",
                "PGEL",
                "PGHH",
                "PGHL",
                "PGIL",
                "PHILIPCARB",
                "PHOENIXLTD",
                "PIDILITIND",
                "PIIND",
                "PILANIINVS",
                "PILITA",
                "PIONDIST",
                "PIONEEREMB",
                "PITTIENG",
                "PKTEA",
                "PLASTIBLEN",
                "PNB",
                "PNBGILTS",
                "PNBHOUSING",
                "PNC",
                "PNCINFRA",
                "PODDARHOUS",
                "PODDARMENT",
                "POKARNA",
                "POLYCAB",
                "POLYMED",
                "POLYPLEX",
                "PONNIERODE",
                "POWERGRID",
                "POWERINDIA",
                "POWERMECH",
                "PPAP",
                "PPL",
                "PRABHAT",
                "PRADIP",
                "PRAENG",
                "PRAJIND",
                "PRAKASH",
                "PRAKASHSTL",
                "PRAXIS",
                "PRECAM",
                "PRECOT",
                "PRECWIRE",
                "PREMEXPLN",
                "PREMIER",
                "PREMIERPOL",
                "PRESSMN",
                "PRESTIGE",
                "PRICOLLTD",
                "PRIMESECU",
                "PRINCEPIPE",
                "PROZONINTU",
                "PRSMJOHNSN",
                "PSB",
                "PSL",
                "PSPPROJECT",
                "PSUBNKBEES",
                "PTC",
                "PTL",
                "PUNJABCHEM",
                "PUNJLLOYD",
                "PURVA",
                "PVR",
                "QGOLDHALF",
                "QNIFTY",
                "QUESS",
                "QUICKHEAL",
                "RADICO",
                "RADIOCITY",
                "RAIN",
                "RAJESHEXPO",
                "RAJRATAN",
                "RAJSREESUG",
                "RAJTV",
                "RALLIS",
                "RAMANEWS",
                "RAMASTEEL",
                "RAMCOCEM",
                "RAMCOIND",
                "RAMCOSYS",
                "RAMKY",
                "RAMSARUP",
                "RANASUG",
                "RANEENGINE",
                "RANEHOLDIN",
                "RATNAMANI",
                "RAYMOND",
                "RBL",
                "RBLBANK",
                "RCF",
                "RCOM",
                "RECLTD",
                "RECLTD",
                "RECLTD",
                "RECLTD",
                "RECLTD",
                "RECLTD",
                "RECLTD",
                "RECLTD",
                "REDINGTON",
                "REFEX",
                "RELAXO",
                "RELCAPITAL",
                "RELIANCE",
                "RELIANCEPP",
                "RELIGARE",
                "RELINFRA",
                "REMSONSIND",
                "RENUKA",
                "REPCOHOME",
                "REPL",
                "REPRO",
                "RESPONIND",
                "REVATHI",
                "RGL",
                "RHFL",
                "RHFL",
                "RICOAUTO",
                "RIIL",
                "RITES",
                "RKDL",
                "RKEC",
                "RKFORGE",
                "RMCL",
                "RML",
                "RNAVAL",
                "ROHITFERRO",
                "ROHLTD",
                "ROLLT",
                "ROLTA",
                "ROSSARI",
                "ROSSELLIND",
                "RPGLIFE",
                "RPOWER",
                "RPPINFRA",
                "RPPL",
                "RSSOFTWARE",
                "RSWM",
                "RSYSTEMS",
                "RTNINFRA",
                "RTNPOWER",
                "RUBYMILLS",
                "RUCHI",
                "RUCHINFRA",
                "RUCHIRA",
                "RUPA",
                "RUSHIL",
                "RVNL",
                "S&SPOWER",
                "SABEVENTS",
                "SABTN",
                "SADBHAV",
                "SADBHIN",
                "SAFARI",
                "SAGARDEEP",
                "SAGCEM",
                "SAIL",
                "SAKAR",
                "SAKHTISUG",
                "SAKSOFT",
                "SAKUMA",
                "SALASAR",
                "SALONA",
                "SALSTEEL",
                "SALZERELEC",
                "SAMBHAAV",
                "SANCO",
                "SANDESH",
                "SANDHAR",
                "SANGAMIND",
                "SANGHIIND",
                "SANGHVIFOR",
                "SANGHVIMOV",
                "SANGINITA",
                "SANOFI",
                "SANWARIA",
                "SARDAEN",
                "SAREGAMA",
                "SARLAPOLY",
                "SARVESHWAR",
                "SASKEN",
                "SASTASUNDR",
                "SATIA",
                "SATIN",
                "SBICARD",
                "SBIETFQLTY",
                "SBILIFE",
                "SBIN",
                "SBIN",
                "SBIN",
                "SCAPDVR",
                "SCHAEFFLER",
                "SCHAND",
                "SCHNEIDER",
                "SCI",
                "SDBL",
                "SEAMECLTD",
                "SELAN",
                "SELMCL",
                "SEPOWER",
                "SEQUENT",
                "SERVOTECH",
                "SESHAPAPER",
                "SETCO",
                "SETF10GILT",
                "SETFGOLD",
                "SETFNIF50",
                "SETFNIFBK",
                "SETFNN50",
                "SETUINFRA",
                "SEYAIND",
                "SEZAL",
                "SFL",
                "SGBAPR28I",
                "SGBAUG24",
                "SGBAUG27",
                "SGBAUG28V",
                "SGBDC27VII",
                "SGBFEB24",
                "SGBFEB28IX",
                "SGBJ28VIII",
                "SGBJAN27",
                "SGBJUL25",
                "SGBJUL27",
                "SGBJUL28IV",
                "SGBJUN27",
                "SGBJUN28",
                "SGBMAR24",
                "SGBMAR25",
                "SGBMAR28X",
                "SGBMAY25",
                "SGBMAY26",
                "SGBMAY28",
                "SGBNOV23",
                "SGBNOV24",
                "SGBNOV25",
                "SGBNOV258",
                "SGBNOV26",
                "SGBOCT25",
                "SGBOCT25IV",
                "SGBOCT25V",
                "SGBOCT26",
                "SGBOCT27",
                "SGBOCT27VI",
                "SGBSEP24",
                "SGBSEP27",
                "SGL",
                "SHAHALLOYS",
                "SHAKTIPUMP",
                "SHALBY",
                "SHALPAINTS",
                "SHANKARA",
                "SHANTIGEAR",
                "SHARDACROP",
                "SHARDAMOTR",
                "SHARIABEES",
                "SHEMAROO",
                "SHIL",
                "SHILPAMED",
                "SHIRPUR-G",
                "SHIVAMAUTO",
                "SHIVAMILLS",
                "SHIVATEX",
                "SHK",
                "SHOPERSTOP",
                "SHREDIGCEM",
                "SHREECEM",
                "SHREEPUSHK",
                "SHREERAMA",
                "SHRENIK",
                "SHREYANIND",
                "SHREYAS",
                "SHRIPISTON",
                "SHRIRAMCIT",
                "SHRIRAMEPC",
                "SHUBHLAXMI",
                "SHYAMCENT",
                "SICAGEN",
                "SICAL",
                "SIEMENS",
                "SIGIND",
                "SIKKO",
                "SIL",
                "SILINV",
                "SILLYMONKS",
                "SIMBHALS",
                "SIMPLEXINF",
                "SINTEX",
                "SIRCA",
                "SIS",
                "SITINET",
                "SIYSIL",
                "SJVN",
                "SKFINDIA",
                "SKIL",
                "SKIPPER",
                "SKMEGGPROD",
                "SMARTLINK",
                "SMLISUZU",
                "SMPL",
                "SMSLIFE",
                "SMSPHARMA",
                "SNOWMAN",
                "SOBHA",
                "SOFTTECH",
                "SOLARA",
                "SOLARINDS",
                "SOMANYCERA",
                "SOMATEX",
                "SOMICONVEY",
                "SONATSOFTW",
                "SORILINFRA",
                "SOTL",
                "SOUTHBANK",
                "SOUTHWEST",
                "SPAL",
                "SPANDANA",
                "SPARC",
                "SPCENET",
                "SPECIALITY",
                "SPENCERS",
                "SPENTEX",
                "SPIC",
                "SPICEJET",
                "SPLIL",
                "SPMLINFRA",
                "SPTL",
                "SPYL",
                "SREEL",
                "SREIBNPNCD",
                "SREIBNPNCD",
                "SREIBNPNCD",
                "SREIBNPNCD",
                "SREIBNPNCD",
                "SREIBNPNCD",
                "SREIBNPNCD",
                "SREIBNPNCD",
                "SREIBNPNCD",
                "SREIBNPNCD",
                "SREIBNPNCD",
                "SREIBNPNCD",
                "SREINFRA",
                "SRF",
                "SRHHYPOLTD",
                "SRIPIPES",
                "SRTRANSFIN",
                "SRTRANSFIN",
                "SRTRANSFIN",
                "SRTRANSFIN",
                "SRTRANSFIN",
                "SRTRANSFIN",
                "SRTRANSFIN",
                "SRTRANSFIN",
                "SRTRANSFIN",
                "SRTRANSFIN",
                "SRTRANSFIN",
                "SRTRANSFIN",
                "SRTRANSFIN",
                "SRTRANSFIN",
                "SRTRANSFIN",
                "SRTRANSFIN",
                "SRTRANSFIN",
                "SRTRANSFIN",
                "SRTRANSFIN",
                "SRTRANSFIN",
                "SSWL",
                "STAR",
                "STARCEMENT",
                "STARPAPER",
                "STCINDIA",
                "STEELCITY",
                "STEELXIND",
                "STEL",
                "STERTOOLS",
                "STINDIA",
                "STRTECH",
                "SUBCAPCITY",
                "SUBEX",
                "SUBROS",
                "SUDARSCHEM",
                "SUJANAUNI",
                "SUMEETINDS",
                "SUMICHEM",
                "SUMIT",
                "SUMMITSEC",
                "SUNCLAYLTD",
                "SUNDARAM",
                "SUNDARMFIN",
                "SUNDARMHLD",
                "SUNDRMBRAK",
                "SUNDRMFAST",
                "SUNFLAG",
                "SUNPHARMA",
                "SUNTECK",
                "SUNTV",
                "SUPERHOUSE",
                "SUPERSPIN",
                "SUPPETRO",
                "SUPRAJIT",
                "SUPREMEIND",
                "SUPREMEINF",
                "SURANASOL",
                "SURANAT&P",
                "SURYALAXMI",
                "SURYAROSNI",
                "SUTLEJTEX",
                "SUULD",
                "SUVEN",
                "SUVENPHAR",
                "SUZLON",
                "SVLL",
                "SWANENERGY",
                "SWARAJENG",
                "SWELECTES",
                "SWSOLAR",
                "SYMPHONY",
                "SYNCOM",
                "SYNGENE",
                "TAINWALCHM",
                "TAJGVK",
                "TAKE",
                "TALBROAUTO",
                "TALWALKARS",
                "TALWGYM",
                "TANLA",
                "TANTIACONS",
                "TARMAT",
                "TASTYBITE",
                "TATACAPHSG",
                "TATACAPHSG",
                "TATACAPHSG",
                "TATACAPHSG",
                "TATACAPHSG",
                "TATACHEM",
                "TATACOFFEE",
                "TATACOMM",
                "TATACONSUM",
                "TATAELXSI",
                "TATAINVEST",
                "TATAMETALI",
                "TATAMOTORS",
                "TATAMTRDVR",
                "TATAPOWER",
                "TATASTEEL",
                "TATASTLBSL",
                "TATASTLLP",
                "TATASTLPP",
                "TBZ",
                "TCFSL",
                "TCFSL",
                "TCFSL",
                "TCFSL",
                "TCFSL",
                "TCFSL",
                "TCI",
                "TCIDEVELOP",
                "TCIEXP",
                "TCIFINANCE",
                "TCNSBRANDS",
                "TCPLPACK",
                "TCS",
                "TDPOWERSYS",
                "TEAMLEASE",
                "TECHIN",
                "TECHM",
                "TECHNOE",
                "TECHNOFAB",
                "TEJASNET",
                "TERASOFT",
                "TEXINFRA",
                "TEXMOPIPES",
                "TEXRAIL",
                "TFCILTD",
                "TGBHOTELS",
                "THANGAMAYL",
                "THEINVEST",
                "THEJO",
                "THEMISMED",
                "THERMAX",
                "THOMASCOOK",
                "THOMASCOTT",
                "THYROCARE",
                "TI",
                "TIDEWATER",
                "TIIL",
                "TIINDIA",
                "TIJARIA",
                "TIL",
                "TIMESGTY",
                "TIMETECHNO",
                "TIMKEN",
                "TINPLATE",
                "TIPSINDLTD",
                "TIRUMALCHM",
                "TIRUPATIFL",
                "TITAN",
                "TMRVL",
                "TNPETRO",
                "TNPL",
                "TNTELE",
                "TOKYOPLAST",
                "TORNTPHARM",
                "TORNTPOWER",
                "TOTAL",
                "TOUCHWOOD",
                "TPLPLASTEH",
                "TREEHOUSE",
                "TREJHARA",
                "TRENT",
                "TRF",
                "TRIDENT",
                "TRIGYN",
                "TRIL",
                "TRITURBINE",
                "TRIVENI",
                "TTKHLTCARE",
                "TTKPRESTIG",
                "TTL",
                "TTML",
                "TV18BRDCST",
                "TVSELECT",
                "TVSMOTOR",
                "TVSSRICHAK",
                "TVTODAY",
                "TVVISION",
                "TWL",
                "UBL",
                "UCALFUEL",
                "UCOBANK",
                "UFLEX",
                "UFO",
                "UGARSUGAR",
                "UJAAS",
                "UJJIVAN",
                "UJJIVANSFB",
                "ULTRACEMCO",
                "UMANGDAIRY",
                "UMESLTD",
                "UNICHEMLAB",
                "UNIENTER",
                "UNIONBANK",
                "UNIPLY",
                "UNITECH",
                "UNITEDTEA",
                "UNITY",
                "UNIVASTU",
                "UNIVCABLES",
                "UNIVPHOTO",
                "UPL",
                "URJA",
                "USHAMART",
                "UTIFEFRGR4",
                "UTINEXT50",
                "UTINIFTETF",
                "UTISENSETF",
                "UTISXN50",
                "UTTAMSTL",
                "UTTAMSUGAR",
                "UVSL",
                "V2RETAIL",
                "VADILALIND",
                "VAIBHAVGBL",
                "VAISHALI",
                "VAKRANGEE",
                "VARDHACRLC",
                "VARDMNPOLY",
                "VARROC",
                "VASCONEQ",
                "VASWANI",
                "VBL",
                "VEDL",
                "VENKEYS",
                "VENUSREM",
                "VERA",
                "VERTOZ",
                "VESUVIUS",
                "VETO",
                "VGUARD",
                "VHL",
                "VICEROY",
                "VIDEOIND",
                "VIDHIING",
                "VIJIFIN",
                "VIKASECO",
                "VIKASMCORP",
                "VIKASPROP",
                "VIKASWSP",
                "VIMTALABS",
                "VINATIORGA",
                "VINDHYATEL",
                "VINYLINDIA",
                "VIPCLOTHNG",
                "VIPIND",
                "VIPULLTD",
                "VISAKAIND",
                "VISASTEEL",
                "VISHAL",
                "VISHNU",
                "VISHWARAJ",
                "VIVIDHA",
                "VIVIMEDLAB",
                "VLSFINANCE",
                "VMART",
                "VOLTAMP",
                "VOLTAS",
                "VRLLOG",
                "VSSL",
                "VSTIND",
                "VSTTILLERS",
                "VTL",
                "WABAG",
                "WABCOINDIA",
                "WALCHANNAG",
                "WANBURY",
                "WATERBASE",
                "WEBELSOLAR",
                "WEIZMANIND",
                "WELCORP",
                "WELENT",
                "WELINV",
                "WELSPUNIND",
                "WENDT",
                "WESTLIFE",
                "WHEELS",
                "WHIRLPOOL",
                "WILLAMAGOR",
                "WINDMACHIN",
                "WIPL",
                "WIPRO",
                "WOCKPHARMA",
                "WONDERLA",
                "WORTH",
                "WSI",
                "WSTCSTPAPR",
                "XCHANGING",
                "XELPMOC",
                "XPROINDIA",
                "YESBANK",
                "ZEEL",
                "ZEEL",
                "ZEELEARN",
                "ZEEMEDIA",
                "ZENITHEXPO",
                "ZENITHSTL",
                "ZENSARTECH",
                "ZENTEC",
                "ZICOM",
                "ZODIAC",
                "ZODIACLOTH",
                "ZODJRDMKJ",
                "ZOTA",
                "ZUARI",
                "ZUARIGLOB",
                "ZYDUSWELL"
                );
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                security_name = item;
                Snackbar.make(view, "YOU HAVE SELECTED " + item, Snackbar.LENGTH_LONG).show();
            }
        });

        return root;
    }
    private TextWatcher buy1change = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String q_val = qt1.getText().toString();

            if(q_val.matches(""))
            {
                tt1.setText("0");

            }
            else
            {
                String by_val = buy1.getText().toString();
                Integer q1= Integer.valueOf(q_val);
                if(!(by_val.matches("")))
                {
                    Integer by = Integer.valueOf(by_val);
                    Integer totall1 = q1*by;
                    Log.e("homefrag","the value is="+totall1);
                    String txt = String.valueOf(totall1);
                    tt1.setText(txt);

                   Integer old_val = Integer.valueOf(tt1.getText().toString());

                   String v = String.valueOf(old_val);
                   total_tt.setText(v);
                }

            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    private TextWatcher buy2change = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String q_val2 = qt2.getText().toString();

            if(q_val2.matches(""))
            {
                tt2.setText("0");

            }
            else
            {
                String by_val2 = buy2.getText().toString();
                Integer q1= Integer.valueOf(q_val2);
                if(!(by_val2.matches("")))
                {
                    Integer by = Integer.valueOf(by_val2);
                    Integer totall1 = q1*by;
                    Log.e("homefrag","the value is="+totall1);
                    String txt = String.valueOf(totall1);
                    tt2.setText(txt);
                    Integer old_val = Integer.valueOf(tt1.getText().toString());
                    Integer old_val2 = Integer.valueOf(tt2.getText().toString());
                    Integer old_val3 = old_val+old_val2;
                    String v = String.valueOf(old_val3);
                    total_tt.setText(v);
                }

            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    private TextWatcher buy3change = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String q_val3 = qt3.getText().toString();

            if(q_val3.matches(""))
            {
                tt3.setText("0");

            }
            else
            {
                String by_val = buy3.getText().toString();
                Integer q1= Integer.valueOf(q_val3);
                if(!(by_val.matches("")))
                {
                    Integer by = Integer.valueOf(by_val);
                    Integer totall1 = q1*by;
                    Log.e("homefrag","the value is="+totall1);
                    String txt = String.valueOf(totall1);
                    tt3.setText(txt);
                    Integer old_val = Integer.valueOf(tt1.getText().toString());
                    Integer old_val2 = Integer.valueOf(tt2.getText().toString());
                    Integer old_val3 = Integer.valueOf(tt3.getText().toString());
                    Integer old_val4 = old_val+old_val2+old_val3;
                    String v = String.valueOf(old_val4);
                    total_tt.setText(v);
                }

            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    private TextWatcher buy4change = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String q_val4 = qt4.getText().toString();

            if(q_val4.matches(""))
            {
                tt4.setText("0");

            }
            else
            {
                String by_val = buy4.getText().toString();
                Integer q1= Integer.valueOf(q_val4);
                if(!(by_val.matches("")))
                {
                    Integer by = Integer.valueOf(by_val);
                    Integer totall1 = q1*by;
                    Log.e("homefrag","the value is="+totall1);
                    String txt = String.valueOf(totall1);
                    tt4.setText(txt);
                    Integer old_val = Integer.valueOf(tt1.getText().toString());
                    Integer old_val2 = Integer.valueOf(tt2.getText().toString());
                    Integer old_val3 = Integer.valueOf(tt3.getText().toString());
                    Integer old_val4 = Integer.valueOf(tt4.getText().toString());
                    Integer old_val5 = old_val+old_val2+old_val3+old_val4;
                    String v = String.valueOf(old_val5);
                    total_tt.setText(v);
                }

            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    private TextWatcher buy5change = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String q_val = qt5.getText().toString();

            if(q_val.matches(""))
            {
                tt5.setText("0");

            }
            else
            {
                String by_val = buy5.getText().toString();
                Integer q1= Integer.valueOf(q_val);
                if(!(by_val.matches("")))
                {
                    Integer by = Integer.valueOf(by_val);
                    Integer totall1 = q1*by;
                    Log.e("homefrag","the value is="+totall1);
                    String txt = String.valueOf(totall1);
                    tt5.setText(txt);
                    Integer old_val = Integer.valueOf(tt1.getText().toString());
                    Integer old_val2 = Integer.valueOf(tt2.getText().toString());
                    Integer old_val3 = Integer.valueOf(tt3.getText().toString());
                    Integer old_val4 = Integer.valueOf(tt4.getText().toString());
                    Integer old_val5 = Integer.valueOf(tt5.getText().toString());
                    Integer old_val6 = old_val+old_val2+old_val3+old_val4+old_val5;
                    String v = String.valueOf(old_val6);
                    total_tt.setText(v);
                }

            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    private TextWatcher q1change = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String q_val = buy1.getText().toString();

            if(q_val.matches(""))
            {
                tt1.setText("0");

            }
            else
            {
                String by_val = qt1.getText().toString();
                Integer q1= Integer.valueOf(q_val);
                if(!(by_val.matches("")))
                {
                    Integer by = Integer.valueOf(by_val);
                    Integer totall1 = q1*by;
                    Log.e("homefrag","the value is="+totall1);
                    String txt = String.valueOf(totall1);
                    tt1.setText(txt);
                    Integer old_val = Integer.valueOf(tt1.getText().toString());

                    Integer old_val6 = old_val;
                    String v = String.valueOf(old_val6);
                    total_tt.setText(v);
                }

            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    private TextWatcher q2change = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String q_val = buy2.getText().toString();

            if(q_val.matches(""))
            {
                tt2.setText("0");

            }
            else
            {
                String by_val = qt2.getText().toString();
                Integer q1= Integer.valueOf(q_val);
                if(!(by_val.matches("")))
                {
                    Integer by = Integer.valueOf(by_val);
                    Integer totall1 = q1*by;
                    Log.e("homefrag","the value is="+totall1);
                    String txt = String.valueOf(totall1);
                    tt2.setText(txt);
                    Integer old_val = Integer.valueOf(tt1.getText().toString());
                    Integer old_val2 = Integer.valueOf(tt2.getText().toString());

                    Integer old_val6 = old_val+old_val2;
                    String v = String.valueOf(old_val6);
                    total_tt.setText(v);
                }

            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    private TextWatcher q3change = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String q_val = buy3.getText().toString();

            if(q_val.matches(""))
            {
                tt3.setText("0");

            }
            else
            {
                String by_val = qt3.getText().toString();
                Integer q1= Integer.valueOf(q_val);
                if(!(by_val.matches("")))
                {
                    Integer by = Integer.valueOf(by_val);
                    Integer totall1 = q1*by;
                    Log.e("homefrag","the value is="+totall1);
                    String txt = String.valueOf(totall1);
                    tt3.setText(txt);
                    Integer old_val = Integer.valueOf(tt1.getText().toString());
                    Integer old_val2 = Integer.valueOf(tt2.getText().toString());
                    Integer old_val3 = Integer.valueOf(tt3.getText().toString());

                    Integer old_val6 = old_val+old_val2+old_val3;
                    String v = String.valueOf(old_val6);
                    total_tt.setText(v);
                }

            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    private TextWatcher q4change = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String q_val = buy4.getText().toString();

            if(q_val.matches(""))
            {
                tt4.setText("0");


            }
            else
            {
                String by_val = qt4.getText().toString();
                Integer q1= Integer.valueOf(q_val);
                if(!(by_val.matches("")))
                {
                    Integer by = Integer.valueOf(by_val);
                    Integer totall1 = q1*by;
                    Log.e("homefrag","the value is="+totall1);
                    String txt = String.valueOf(totall1);
                    tt4.setText(txt);
                    Integer old_val = Integer.valueOf(tt1.getText().toString());
                    Integer old_val2 = Integer.valueOf(tt2.getText().toString());
                    Integer old_val3 = Integer.valueOf(tt3.getText().toString());
                    Integer old_val4 = Integer.valueOf(tt4.getText().toString());
                    Integer old_val6 = old_val+old_val2+old_val3+old_val4;
                    String v = String.valueOf(old_val6);
                    total_tt.setText(v);
                }

            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    private TextWatcher q5change = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String q_val = buy5.getText().toString();

            if(q_val.matches(""))
            {
                tt5.setText("0");

            }
            else
            {
                String by_val = qt5.getText().toString();
                Integer q1= Integer.valueOf(q_val);
                if(!(by_val.matches("")))
                {
                    Integer by = Integer.valueOf(by_val);
                    Integer totall1 = q1*by;
                    Log.e("homefrag","the value is="+totall1);
                    String txt = String.valueOf(totall1);
                    tt5.setText(txt);
                    Integer old_val = Integer.valueOf(tt1.getText().toString());
                    Integer old_val2 = Integer.valueOf(tt2.getText().toString());
                    Integer old_val3 = Integer.valueOf(tt3.getText().toString());
                    Integer old_val4 = Integer.valueOf(tt4.getText().toString());
                    Integer old_val5 = Integer.valueOf(tt5.getText().toString());
                    Integer old_val6 = old_val+old_val2+old_val3+old_val4+old_val5;
                    String v = String.valueOf(old_val6);
                    total_tt.setText(v);
                }

            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    @Override
    public void onStart() {
        super.onStart();

    }
}
