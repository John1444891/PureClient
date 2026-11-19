package com.example;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class PureClientScreen extends Screen {
    public PureClientScreen() {
        super(Text.literal("Pure Client"));
    }

    @Override
    protected void init() {
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Multiplayer").formatted(Formatting.WHITE), button -> {
            this.client.setScreen(new net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen(this));
        }).dimensions(this.width / 2 - 100, this.height / 2 - 40, 200, 20).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal("Settings").formatted(Formatting.WHITE), button -> {
            this.client.setScreen(new net.minecraft.client.gui.screen.option.OptionsScreen(this, this.client.options));
        }).dimensions(this.width / 2 - 100, this.height / 2 + 20, 200, 20).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.fill(0, 0, this.width, this.height, 0xCC0F0A14); 
        context.drawCenteredTextWithShadow(this.textRenderer, "PURE CLIENT", this.width / 2, this.height / 2 - 80, 0xA855F7);
        super.render(context, mouseX, mouseY, delta);
    }
}
