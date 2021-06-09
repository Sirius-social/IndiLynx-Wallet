package com.sirius.travelpass.base.data.models

/**
 * Status of a resource that is provided to the UI.
 *
 *
 * These are usually created by the Repository classes where they return
 * `LiveData<Resource<T>>` to pass back the latest data to the UI with its fetch status.
 */
enum class MessageAction {
    UPDATE,
    ADD,
    ADD_RANGE,
    DELETE,
    CHANGE,
    SET,
    WAIT
}