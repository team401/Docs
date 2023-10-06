---
title: Finding Gear Tooth Count
parent: Design How-To's
layout: home
---



# Finding Gear Tooth Count

Students occasionally need to identify tooth a gear used in a prototype or previous year mechanism. Often in this situation students will resort to manually counting either the entire gear or a sector of the gear and then multiplying. While this does work it can be slow for large tooth count gears and is susceptible to human error in both the count itself and in assumptions- not all gears have an even tooth count so counting sectors may not work!

Instead of counting, the [equation for gear outer diameter](Gears.md#equations) can be leveraged: $$OD = \frac{K_t + 2}{DP}$$

Rearranging terms it can be found that: $$ K_t = OD * DP - 2$$. 

Simply measuring the outer diameter of a gear and knowing the diametrical pitch is sufficient to find the number of teeth!

### Examples

- A 20 DP gear with 3.5" OD: 

  $$ K_t = OD * DP - 2 \\ K_t = 3.5 * 20 - 2 \\ K_t = 68$$

- Or for a 32 DP gear with 0.4375" OD:

  $$ K_t = OD * DP - 2 \\ K_t = 0.4375 * 32 - 2 \\ K_t = 12$$

