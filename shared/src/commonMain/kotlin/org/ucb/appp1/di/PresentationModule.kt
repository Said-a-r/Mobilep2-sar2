package org.ucb.appp1.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.ucb.appp1.Crypto.Presentation.viewmodel.CryptoViewModel
import org.ucb.appp1.signin.presentation.viewmodel.LoginViewModel
import org.ucb.appp1.userinformation.presentation.viewmodel.UserInformationViewModel

val presentationModule = module {

    viewModelOf (::CryptoViewModel)

    viewModelOf(::LoginViewModel)
    viewModelOf(::UserInformationViewModel)
}
