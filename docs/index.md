# 401 Docs Overview

401 Docs was started in the summer of 2019 and is an ongoing effort to improve Team 401 by documenting our procedures and experiences.

## Testing and Running Locally

This site uses [Material for MkDocs](https://squidfunk.github.io/mkdocs-material/), visit their docs to see what customization options are available.

Clone this repo by running: `#!bash git clone https://github.com/team401/Docs`

Then install Material for MkDocs and its dependencies: `#!bash pip install -r requirements.txt`

Serve the site locally: `#!bash mkdocs serve`

## Project layout

    mkdocs.yml    # The configuration file.
    docs/
        index.md  # The documentation homepage.
        programming/
            index.md # Programming section homepage
            ... # Other programming files
        ... # Other markdown pages, images and other files.
