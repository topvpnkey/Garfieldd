context.fill(
                left + 8, cy + 88,
                right - 8, cy + 89,
                0x22FFFFFF
            );
        }

        // PARTICLE EFFECT

        if (particles) {
            long time = System.currentTimeMillis();

            for (int i = 0; i < 12; i++) {
                int px = left + 15
                    + (int) (
                        Math.abs(
                            Math.sin(time * 0.001 + i * 1.7)
                        ) * Math.max(1, panelWidth - 30)
                    );

                int py = cy - 70
                    + (int) (
                        Math.abs(
                            Math.cos(time * 0.0015 + i)
                        ) * 135
                    );

                context.fill(
                    px, py,
                    px + 2, py + 2,
                    accent
                );
            }
        }

        // LOGO

        context.drawCenteredTextWithShadow(
            textRenderer,
            Text.literal("GARFIELD"),
            cx,
            cy - 76,
            accent
        );

        context.drawCenteredTextWithShadow(
            textRenderer,
            Text.literal("ULTIMATE  /  LIQUID GLASS"),
            cx,
            cy - 65,
            theme == 1 ? 0xFF25384A : 0xFFE0E7F0
        );

        // CURRENT SECTION

        context.drawCenteredTextWithShadow(
            textRenderer,
            Text.literal(TABS[selectedTab]),
            cx,
            cy + 48,
            accent
        );

        // ANIMATED UNDERLINE

        if (animations) {
            int lineWidth = 30
                + (int) (
                    Math.abs(
                        Math.sin(
                            (System.currentTimeMillis() - openedAt)
                            / 350.0
                        )
                    ) * 65
                );

            context.fill(
                cx - lineWidth,
                cy + 59,
                cx + lineWidth,
                cy + 60,
                accent
            );
        } else {
            context.fill(
                cx - 30,
                cy + 59,
                cx + 30,
                cy + 60,
                accent
            );
        }

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
