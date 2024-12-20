package com.example.lamp.di

import com.example.lamp.presenter.MainFragment
import dagger.Component

@Component(
    modules = [
        ViewModelModule::class,
        NetworkModule::class,
        AppBindModule::class,
    ]
)
interface AppComponent {
    fun inject(fragment: MainFragment)
}