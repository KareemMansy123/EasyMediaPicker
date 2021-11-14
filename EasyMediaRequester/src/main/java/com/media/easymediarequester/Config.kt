package com.media.easymediarequester

class Config {
    lateinit var type: RequestType

    class Builder {
        private val config = Config()
        fun requestType(value : RequestType): Builder {
            config.type = value
            return this
        }

        fun build() = config
    }

}