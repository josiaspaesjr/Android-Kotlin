package tech.ludy.android_kotlin_mvp.mvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.paes.josias.android_kotlin_mvp.mvp.MainContract
import com.paes.josias.android_kotlin_mvp.mvp.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import tech.ludy.android_kotlin_mvp.R

class MainActivity : AppCompatActivity(), MainContract.MyView {

    val mPresenter:MainPresenter by lazy { MainPresenter(this@MainActivity) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calc(v:View){
        val btn:Button = v as Button
        var num01 = if (!etNum1.text.toString().isNullOrEmpty()) etNum1.text.toString().toInt() else 0
        var num02 = if (!etNum2.text.toString().isNullOrEmpty()) etNum2.text.toString().toInt() else 0
        mPresenter.calc(btn.text.toString(),
                num01,
                num02)
    }

    override fun setResult(result:String) {
        tvResult.text = result
    }
}
