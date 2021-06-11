package com.sirius.travelpass.ui.auth.auth_third

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher

import androidx.lifecycle.Observer
import com.sirius.travelpass.R
import com.sirius.travelpass.base.App
import com.sirius.travelpass.base.ui.BaseFragment

import com.sirius.travelpass.databinding.FragmentAuthSecondBinding
import com.sirius.travelpass.databinding.FragmentAuthThirdBinding


class AuthThirdFragment : BaseFragment<FragmentAuthThirdBinding, AuthThirdViewModel>() {

    override fun setupViews() {
        super.setupViews()

        dataBinding.indicatorView.selectPage(3)
        dataBinding.phoneEditText.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                model.setPhone(s.toString())
                model.isNextEnabled()
            }

        })

        dataBinding.emailEditText.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                model.setUserEmail(s.toString())
                model.isNextEnabled()
            }

        })
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_auth_third
    }

    override fun initDagger() {
        App.getInstance().appComponent.inject(this)
    }

    override fun subscribe() {


        model.goToTypeInfoScreenLiveData.observe(this, Observer {
            if (it) {
                model.goToTypeInfoScreenLiveData.value = false
             //   baseActivity.pushPage(RegisterTypeInfoFragment())
            }
        })
    }

    override fun setModel() {
        dataBinding.viewModel = model
    }


}