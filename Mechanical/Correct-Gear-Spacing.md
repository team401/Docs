---
title: Correct Gear Spacing
parent: Design How-To's
layout: home
---

# Correct Gear Spacing

Finding the correct spacing for gears is a very common task in the design process. Given just the diametrical pitch of a pair of gears and their tooth counts the correct center-to-center distance is easy to find.

The [equation for center distance](Gears.md#equations) is $$ CtoC = \frac{PD_1 + PD_2}{2}$$ where $$PD_1$$ and $$PD_2$$ are the pitch diameters of the gears as defined by $$ PD = \frac{K_t}{DP}$$

Combining our equations and rearranging terms a bit:

$$ CtoC = \frac{PD_1 + PD_2}{2} \\CtoC = \frac{\frac{K_{t1}}{DP} + \frac{K_{t2}}{DP}}{2} \\ CtoC = \frac{K_{t1} + K_{t2}}{2*DP}$$

This gives us an easy way to find center-to-center distance using just gear tooth counts and diametrical pitch. Remembering that our manufacturing processes aren't perfect we add a static 0.003" to ensure the gears don't bind and end up with our final equation:

$$ CtoC = \frac{K_{t1} + K_{t2}}{2*DP} + 0.003\text{"}$$

### Examples

- A 20 DP 12 tooth gear meshes with an 84 tooth gear:

  $$ CtoC = \frac{K_{t1} + K_{t2}}{2*DP} + 0.003\text{"} \\ CtoC = \frac{12 + 84}{2 * 20} + 0.003 \text{"}\\ CtoC = 96 / 40 + 0.003\text{"} \\ CtoC = 2.403\text{"}$$

- A 32 DP 20 tooth gear meshes with a 65 tooth gear:

  $$ CtoC = \frac{K_{t1} + K_{t2}}{2*DP} + 0.003\text{"} \\ CtoC = \frac{20 + 65}{2 * 32} + 0.003 \text{"}\\ CtoC = 85 / 64 + 0.003\text{"} \\ CtoC = 1.331\text{"}$$