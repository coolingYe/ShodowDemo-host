package com.example.shadow_host

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.shadow_lib.InitApplication
import com.tencent.shadow.dynamic.host.EnterCallback

class MainActivity : AppCompatActivity() {

    private val FROM_ID_START_ACTIVITY = 1001
    val FROM_ID_CALL_SERVICE = 1002

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val linearLayout = LinearLayout(this)
        linearLayout.orientation = LinearLayout.VERTICAL

        val textView = TextView(this)
        textView.text = "宿主App"

        val button = Button(this)
        button.text = "启动插件"

        button.setOnClickListener {
            it.isEnabled = false
            val pluginManager = InitApplication.getPluginManager()
            pluginManager.enter(this, FROM_ID_START_ACTIVITY.toLong(), Bundle(), object : EnterCallback {
                override fun onShowLoadingView(view: View?) {
                    setContentView(view)
                }

                override fun onCloseLoadingView() {
                    setContentView(linearLayout)
                }

                override fun onEnterComplete() {
                    it.isEnabled = true
                }

            })
        }

        linearLayout.addView(textView)
        linearLayout.addView(button)

        setContentView(linearLayout)
    }
}