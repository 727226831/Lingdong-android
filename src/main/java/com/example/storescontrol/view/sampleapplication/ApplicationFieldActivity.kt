package com.example.storescontrol.view.sampleapplication

import android.os.Bundle

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.storescontrol.R
import com.example.storescontrol.bean.AgmentBean
import com.example.storescontrol.bean.FieldBean
import com.example.storescontrol.url.Request
import com.example.storescontrol.url.Untils
import com.example.storescontrol.view.BaseActivity
import com.google.gson.Gson
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class ApplicationFieldActivity : BaseActivity() {
     var fieldBean:FieldBean?=null
    internal var functionAdapter: FunctionAdapter?=null
    internal var recyclerView: RecyclerView?=null
    private var editTextSearch: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agent_list)
        if(intent.getStringExtra("key").equals("Define29")){
            Untils.initTitle("产品领域", this)
        }else  if(intent.getStringExtra("key").equals("Define31")){
            Untils.initTitle("功能描述", this)
        }

        recyclerView = findViewById(R.id.rv_list)
        editTextSearch = findViewById(R.id.et_search)
        editTextSearch!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun afterTextChanged(editable: Editable) {
                getData(editable.toString())
            }
        })
        getData("")
    }

    private fun getData(keyword: String) {
        dialog.show()
        val jsonObject = JSONObject()
        try {

            jsonObject.put("methodname",intent.getStringExtra("key"))
            jsonObject.put("keyword", keyword)
            jsonObject.put("applicationarea",intent.getStringExtra("applicationarea"))


        } catch (e: JSONException) {
            e.printStackTrace()
        }

        val obj = jsonObject.toString()
        Log.i("json object", obj)

        val data = Request.requestbody(obj)
        data.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: retrofit2.Call<ResponseBody>, response: Response<ResponseBody>) {
                dialog.dismiss()
                try {
                    if (response.code() == 200) {
                        val result = response.body()!!.string()

                       fieldBean= Gson().fromJson(result, FieldBean::class.java)

                        if (fieldBean!!.Resultcode == "200") {
                            if(intent.getStringExtra("key").equals("Define31")){

                                var itemBean=FieldBean.Data();
                                itemBean!!.cDefine31="其他"
                                fieldBean!!.data!!.add(itemBean)

                            }
                            functionAdapter = FunctionAdapter(fieldBean!!.data)

                        } else {
                            val data = LinkedList<FieldBean.Data>()
                            functionAdapter = FunctionAdapter(data)

                            Toast.makeText(this@ApplicationFieldActivity, fieldBean!!.ResultMessage, Toast.LENGTH_LONG).show()
                        }
                        recyclerView!!.layoutManager = LinearLayoutManager(this@ApplicationFieldActivity)
                        recyclerView!!.addItemDecoration(DividerItemDecoration(this@ApplicationFieldActivity, DividerItemDecoration.VERTICAL))
                        recyclerView!!.adapter = functionAdapter


                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }

            override fun onFailure(call: retrofit2.Call<ResponseBody>, t: Throwable) {
                dialog.dismiss()
            }
        })
    }

    internal inner class FunctionAdapter(private val mDatas: List<FieldBean.Data>?) : RecyclerView.Adapter<FunctionAdapter.VH>() {

        override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): VH {
            val v = layoutInflater.inflate(R.layout.item_agent, viewGroup, false)
            return VH(v)
        }

        override fun onBindViewHolder(vh: FunctionAdapter.VH, i: Int) {



            if(intent.getStringExtra("key").equals("Define29")){
                vh.textViewAgent.text = mDatas!![i].cDefine29
            }else  if(intent.getStringExtra("key").equals("Define31")){
                vh.textViewAgent.text = mDatas!![i].cDefine31
            }
            vh.linearLayout.setOnClickListener {
                val product = Untils.getProductBean(this@ApplicationFieldActivity)
                if(intent.getStringExtra("key").equals("Define29")){
                    product.s_ApplicationArea = mDatas!![i].cDefine29
                }else  if(intent.getStringExtra("key").equals("Define31")){
                    product.s_FunctionDescription = mDatas!![i].cDefine31
                }
                Untils.setProductBean(this@ApplicationFieldActivity, product)

                 finish()
            }

        }

        override fun getItemCount(): Int {
            return mDatas!!.size
        }

        internal inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var linearLayout: LinearLayout
            var textViewAgent: TextView

            init {
                linearLayout = itemView.findViewById(R.id.l_layout)
                textViewAgent = itemView.findViewById(R.id.tv_agentvalue)

            }
        }
    }
}
