import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'
import 'vuetify/styles'
import { createVuetify } from 'vuetify'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'


import App from './App.vue'
import router from './router'
import {mdi} from "vuetify/iconsets/mdi";
import {aliases} from "vuetify/iconsets/mdi";
import '@mdi/font/css/materialdesignicons.css'

const app = createApp(App)

const veutify = createVuetify({
    icons: {
        defaultSet: 'mdi',
        aliases,
        sets: {
            mdi
        }
    },
    components,
    directives,
})
app.use(createPinia())
app.use(router)
app.use(veutify)


app.mount('#app')
