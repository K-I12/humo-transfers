
# 📄 Описание макета `activity_main.xml`

Этот файл описывает основной экран приложения с использованием `ConstraintLayout`, внутри которого расположен `NestedScrollView`, содержащий несколько `CardView`-элементов с инструкциями и сообщениями об ошибках.

## 💡 Особенности

### 📌 Управление отображением с помощью `android:visibility`

Некоторые части пользовательского интерфейса показываются или скрываются динамически в зависимости от состояния приложения. Это реализовано через атрибут `android:visibility` с возможными значениями:

- `visible` — элемент видим.
- `invisible` — элемент не видим, но занимает место.
- `gone` — элемент скрыт и не занимает места.

### 👇 Примеры применения

#### Инструкция по переводу

```xml
<LinearLayout
    android:id="@+id/instruction_ll"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:gravity="center_horizontal"
    android:orientation="vertical"
    android:padding="16dp"
    android:visibility="gone"/>
```

#### Загрузка инструкции

```xml
<LinearLayout
    android:id="@+id/instruction_loading_ll"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:gravity="center_horizontal"
    android:orientation="vertical"
    android:padding="16dp"
    android:visibility="gone"/>
```

#### Сообщение об ошибке

```xml
<LinearLayout
    android:id="@+id/instruction_error_ll"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:gravity="center"
    android:orientation="vertical"
    android:padding="16dp"
    android:visibility="visible"/>
```

## 🧠 Логика переключения состояний в `MainActivity.kt`

В коде реализована функция `test()`, которая при нажатии на кнопку `sendButton` циклически переключает отображение между тремя состояниями:

1. Загрузка (loading)
2. Инструкция (instruction)
3. Ошибка (error)

Пример логики переключения:

```kotlin
private fun test() {
    var currentState = 0 // 0 - loading, 1 - instruction, 2 - error

    sendButton.setOnClickListener {
        currentState = (currentState + 1) % 3

        // Скрываем все состояния
        instructionLl.visibility = View.GONE
        instructionLoadingLl.visibility = View.GONE
        instructionErrorLl.visibility = View.GONE

        // Показываем только одно
        when (currentState) {
            0 -> instructionLoadingLl.visibility = View.VISIBLE
            1 -> instructionLl.visibility = View.VISIBLE
            2 -> instructionErrorLl.visibility = View.VISIBLE
        }
    }
}
```