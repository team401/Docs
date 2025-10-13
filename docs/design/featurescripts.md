# Featurescripts

Onshape has its own scripting language to create custom features to automate aspects of design called [Featurescript](https://www.onshape.com/features/custom-features "Onshape Featurescript Page"){:target="_blank"}. There are a lot of featurescripts (what we call the custom features) that make designing for FRC much easier.

## How To Install Featurescripts

1. Open any Onshape document and go inside of a part studio
2. Click the rightmost button on the toolbar that looks like this: ![add custom feature button](/images/design/addCustomFeatures.webp)
    - **Note:** If you have previously added any Featurescripts one of those may show up as the right most icon. In that case click the dropdown to show the add button.
3. Paste the link of the document with the featurescript(s) in it into the search bar
    - **Note:** Some of the below featurescripts exist in the same document, so you can add multiple from the same link.

4. Select the featurescript(s) you want to add to your profile, then exit the box. They will be accessible in all documents from then on in the same drop-down in the toolbar where you added the feature.

!!! Note "Adding Featurescripts while in an Onshape Document"
    When viewing a tab in a document that uses custom features, you can click a button near the top left that says 'custom features'. From here you can add custom features used in the document to your profile.

## Required Featurescripts

These featurescripts are required for all Team 401 design students to install and are extensively used as we design robots.

To install each featurescript:

1. Click the coresponding 'Copy to Clipboard' button
2. Click 'Add Custom Feature' in your Onshape window
3. Paste the copied URL
4. Select the custom feature you need - not all of the features in the Document

| Featurescript | Description | Copy to Clipboard | Onshape Link |
| -- | -- | -- | -- |
| Design Constants | Belt, gear, bolt distances | [Copy to Clipboard](javascript:void(0)){ .md-button .md-button--primary data-clipboard-text="https://cad.onshape.com/documents/780aac08a335649a61c44aaa/w/0b2ae0d562d2207807fb7b74/e/eea661b52c72a077238a2695"} | [Onshape :fontawesome-solid-share-from-square:](https://cad.onshape.com/documents/780aac08a335649a61c44aaa/w/0b2ae0d562d2207807fb7b74/e/eea661b52c72a077238a2695){ .md-button} |
| Extrude Individual | Use one sketch to make multiple tubes | [Copy to Clipboard](javascript:void(0)){ .md-button .md-button--primary data-clipboard-text="https://cad.onshape.com/documents/95c00401c440b44ad8799ef5/v/eea16175f5a62f4905e19ca1/e/f59ee8c28530122eb7fa9f5c"} | [Onshape :fontawesome-solid-share-from-square:](https://cad.onshape.com/documents/95c00401c440b44ad8799ef5/v/eea16175f5a62f4905e19ca1/e/f59ee8c28530122eb7fa9f5c){ .md-button} |
| Tube Converter | Convert Extrudes to Tubes | [Copy to Clipboard](javascript:void(0)){ .md-button .md-button--primary data-clipboard-text="https://cad.onshape.com/documents/95c00401c440b44ad8799ef5/v/3780fb78ddb5f9478d41aeeb/e/7f62400703032fab9a7a3320"} | [Onshape :fontawesome-solid-share-from-square:](https://cad.onshape.com/documents/95c00401c440b44ad8799ef5/v/3780fb78ddb5f9478d41aeeb/e/7f62400703032fab9a7a3320){ .md-button} |
| Spacer | Generate spacers to connect plates | [Copy to Clipboard](javascript:void(0)){ .md-button .md-button--primary data-clipboard-text="https://cad.onshape.com/documents/95c00401c440b44ad8799ef5/v/3780fb78ddb5f9478d41aeeb/e/9d38ab00b89aa97b6c65b7b0"} | [Onshape :fontawesome-solid-share-from-square:](https://cad.onshape.com/documents/95c00401c440b44ad8799ef5/v/3780fb78ddb5f9478d41aeeb/e/9d38ab00b89aa97b6c65b7b0){ .md-button} |
| Shaft | Generate shafts for power transmission | [Copy to Clipboard](javascript:void(0)){ .md-button .md-button--primary data-clipboard-text="https://cad.onshape.com/documents/95c00401c440b44ad8799ef5/v/3780fb78ddb5f9478d41aeeb/e/8db1f48368bdac821997185f"} | [Onshape :fontawesome-solid-share-from-square:](https://cad.onshape.com/documents/95c00401c440b44ad8799ef5/v/3780fb78ddb5f9478d41aeeb/e/8db1f48368bdac821997185f){ .md-button} |
| Gusset | Generate plates to connect tubes | [Copy to Clipboard](javascript:void(0)){ .md-button .md-button--primary data-clipboard-text="https://cad.onshape.com/documents/95c00401c440b44ad8799ef5/v/3780fb78ddb5f9478d41aeeb/e/80b86b695b75c4dcf2be5a7f"} | [Onshape :fontawesome-solid-share-from-square:](https://cad.onshape.com/documents/95c00401c440b44ad8799ef5/v/3780fb78ddb5f9478d41aeeb/e/80b86b695b75c4dcf2be5a7f){ .md-button} |
| Fillet All Edges | Fillets all edges on a part | [Copy to Clipboard](javascript:void(0)){ .md-button .md-button--primary data-clipboard-text="https://cad.onshape.com/documents/95c00401c440b44ad8799ef5/v/3780fb78ddb5f9478d41aeeb/e/be51a7d601bee5eb80c431ad?jumpToIndex=436"} | [Onshape :fontawesome-solid-share-from-square:](https://cad.onshape.com/documents/95c00401c440b44ad8799ef5/v/3780fb78ddb5f9478d41aeeb/e/be51a7d601bee5eb80c431ad?jumpToIndex=436){ .md-button} |
| Part Lighten | Lighten parts with ribs and perimeters | [Copy to Clipboard](javascript:void(0)){ .md-button .md-button--primary data-clipboard-text="https://cad.onshape.com/documents/028ca8fb10baf53e1f6fce96/v/821c8b51ed0953526b51926e/e/a8b9e45297aac9f5688c871d"} | [Onshape :fontawesome-solid-share-from-square:](https://cad.onshape.com/documents/028ca8fb10baf53e1f6fce96/v/821c8b51ed0953526b51926e/e/a8b9e45297aac9f5688c871d){ .md-button} |
| CheeseIt | Lighten parts with patterns | [Copy to Clipboard](javascript:void(0)){ .md-button .md-button--primary data-clipboard-text="https://cad.onshape.com/documents/f46510f08cc311a34733cac2/v/f7f3a1c996c58466f6b88a37/e/af18ea948d73d8e6aafa0767"} | [Onshape :fontawesome-solid-share-from-square:](https://cad.onshape.com/documents/f46510f08cc311a34733cac2/v/f7f3a1c996c58466f6b88a37/e/af18ea948d73d8e6aafa0767){ .md-button} |
| Threads | Create threads in / on 3DP parts | [Copy to Clipboard](javascript:void(0)){ .md-button .md-button--primary data-clipboard-text="https://cad.onshape.com/documents/95c00401c440b44ad8799ef5/v/3780fb78ddb5f9478d41aeeb/e/5e303420d66f4911c362508e"} | [Onshape :fontawesome-solid-share-from-square:](https://cad.onshape.com/documents/95c00401c440b44ad8799ef5/v/3780fb78ddb5f9478d41aeeb/e/5e303420d66f4911c362508e){ .md-button} |
| 3D Printing | Set accurate masses for 3DP parts | [Copy to Clipboard](javascript:void(0)){ .md-button .md-button--primary data-clipboard-text="https://cad.onshape.com/documents/95c00401c440b44ad8799ef5/v/3780fb78ddb5f9478d41aeeb/e/4490f033b69821f5722cc71d"} | [Onshape :fontawesome-solid-share-from-square:](https://cad.onshape.com/documents/95c00401c440b44ad8799ef5/v/3780fb78ddb5f9478d41aeeb/e/4490f033b69821f5722cc71d){ .md-button} |
| Motor Mounting | Mounting holes for FRC motors | [Copy to Clipboard](javascript:void(0)){ .md-button .md-button--primary data-clipboard-text="https://cad.onshape.com/documents/95c00401c440b44ad8799ef5/v/3780fb78ddb5f9478d41aeeb/e/f7d2fd67eee8b713d4a91fb3"} | [Onshape :fontawesome-solid-share-from-square:](https://cad.onshape.com/documents/95c00401c440b44ad8799ef5/v/3780fb78ddb5f9478d41aeeb/e/f7d2fd67eee8b713d4a91fb3){ .md-button} |
| Robot Belt | Generate Belts and Pulleys | [Copy to Clipboard](javascript:void(0)){ .md-button .md-button--primary data-clipboard-text="https://cad.onshape.com/documents/9cffa92db8b62219498f89af/v/05dd06c5cc9ae655a39e5c5d/e/99672d1e329b38e647d90146"} | [Onshape :fontawesome-solid-share-from-square:](https://cad.onshape.com/documents/9cffa92db8b62219498f89af/v/05dd06c5cc9ae655a39e5c5d/e/99672d1e329b38e647d90146){ .md-button} |
| Belt and Chain Gen | Generate Double Sided Belts | [Copy to Clipboard](javascript:void(0)){ .md-button .md-button--primary data-clipboard-text="https://cad.onshape.com/documents/53c0b14cad92676c14e04e97/v/ba3d3c1c31ed90eb4540d8b5/e/7394c4a86d8d6c35c9a12041"} | [Onshape :fontawesome-solid-share-from-square:](https://cad.onshape.com/documents/53c0b14cad92676c14e04e97/v/ba3d3c1c31ed90eb4540d8b5/e/7394c4a86d8d6c35c9a12041){ .md-button} |

## Optional Featurescripts

These featurescripts are not mandatory but make things quicker and are useful to have.

| Featurescript | Description | Copy to Clipboard | Onshape Link |
| -- | -- | -- | -- |
| Corner Overcut | Corners for tab and slot construction | [Copy to Clipboard](javascript:void(0)){ .md-button .md-button--primary data-clipboard-text="https://cad.onshape.com/documents/b99915c0b73924ca981bc57f/w/fe0bd1c034e61bbcdb3e68eb/e/14458d1263a98640a0cf663c"} | [Onshape :fontawesome-solid-share-from-square:](https://cad.onshape.com/documents/b99915c0b73924ca981bc57f/w/fe0bd1c034e61bbcdb3e68eb/e/14458d1263a98640a0cf663c){ .md-button} |
| Auto Layout | Layout Parts for Laser or Waterjet | [Copy to Clipboard](javascript:void(0)){ .md-button .md-button--primary data-clipboard-text="https://cad.onshape.com/documents/576e01dbe4b0cc2e7f46a55d/v/f697250aa149b6846173f4b1/e/887d6e2324589bfd2058c3e1"} | [Onshape :fontawesome-solid-share-from-square:](https://cad.onshape.com/documents/576e01dbe4b0cc2e7f46a55d/v/f697250aa149b6846173f4b1/e/887d6e2324589bfd2058c3e1){ .md-button} |
| T Slot Joint | Create T Slots for Laser or Waterjet | [Copy to Clipboard](javascript:void(0)){ .md-button .md-button--primary data-clipboard-text="https://cad.onshape.com/documents/5791a167e4b03c2aa6af3b35/v/f4f0540312c744f12681a624/e/acc455ae2adcf11a571ba510"} | [Onshape :fontawesome-solid-share-from-square:](https://cad.onshape.com/documents/5791a167e4b03c2aa6af3b35/v/f4f0540312c744f12681a624/e/acc455ae2adcf11a571ba510){ .md-button} |
| Laser Joint | Finger joint for Laser Cutter | [Copy to Clipboard](javascript:void(0)){ .md-button .md-button--primary data-clipboard-text="https://cad.onshape.com/documents/578830e4e4b0e65410f9c34e/v/4a3153e5b4fb5385bd22a9b8/e/7af109b2f1cead90850525ae"} | [Onshape :fontawesome-solid-share-from-square:](https://cad.onshape.com/documents/578830e4e4b0e65410f9c34e/v/4a3153e5b4fb5385bd22a9b8/e/7af109b2f1cead90850525ae){ .md-button} |
| Plate | Creating detailed FRC plates quickly | [Copy to Clipboard](javascript:void(0)){ .md-button .md-button--primary data-clipboard-text="https://cad.onshape.com/documents/9cffa92db8b62219498f89af/v/4d631c107644bbf1a650d6fc/e/f202d95d12d16b67322f5465?jumpToIndex=2672"} | [Onshape :fontawesome-solid-share-from-square:](https://cad.onshape.com/documents/9cffa92db8b62219498f89af/v/4d631c107644bbf1a650d6fc/e/f202d95d12d16b67322f5465?jumpToIndex=2672){ .md-button} |

## Troubleshooting and Updating Featurescripts

If a featurescript is not working as expected, the current version might be broken. You might have to update the featurescript. If it needs updating, the feature will show a blue icon to the right of it that, when hovered over, will say "change version of linked document."

1. The first way to update it is by individually by right clicking the feature you want updated in the feature list and clicking "Update linked document..."
2. The second, and slightly more permanent way (until the maintainer of the custom feature creates a new version), is by right clicking any of the featurescript icons in your toolbar or in the custom features dropdown and clicking "Update..." or "Update all..." From there, you can see the current versions of the custom features you have added to your profile and update selected ones to use the current latest version when you use a featurescript.
