from renderText import renderText, TEST_TEXT
import gradio as gr

def makeGradioApp():
    css = """
    #result img {
        padding: 40px 10px;
    }
    footer {
        visibility: hidden;
    }
    """

    with gr.Blocks(css=css, title="Bunker 3D Fonts", theme=gr.themes.Default(primary_hue=gr.themes.colors.blue)) as demo:
        with gr.Column():
            gr.Markdown(
                "### Используйте шрифты из старых J2ME игр от Netsoftware! (Бункер 3D, Лаборатория 3D, Крепость 3D)\n\n"
                "### Use fonts from the old J2ME Netsoftware games! (Bunker 3D, Laboratory 3D, Castle 3D)\n\n"
            )
            with gr.Row():
                with gr.Column():
                    prompt = gr.Text(
                        label="Ваш текст / Your text",
                        lines=2,
                        value=TEST_TEXT,
                    )
                    updateButton = gr.Button("Обновить / Update")
                    game = gr.Radio(label="Игра / Game", value="b3d", choices=["b3d", "l3d", "c3d"])
                    background = gr.Checkbox(label="Черный фон / Black background", value=True)
                with gr.Column():
                    result = gr.Image(label="Результат / Result", elem_id="result", format="png")
                    charLimit = gr.Slider(label="Лимит символов в строке / Characters limit per line", value=40, minimum=10, maximum=300, scale=1, step=1)
                    scale = gr.Slider(label="Размер пикселей / Pixels size", value=6, minimum=1, maximum=10, scale=1, step=1)
        gr.on(
            triggers=[updateButton.click, game.change, scale.change, charLimit.change, background.change, demo.load],
            fn=renderText,
            inputs=[
                game,
                prompt,
                scale,
                charLimit,
                background,
            ],
            outputs=[
                result
            ],
        )
    return demo


if __name__ == "__main__":
    makeGradioApp().launch()
