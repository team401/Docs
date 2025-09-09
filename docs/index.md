# 401 Docs Overview

401 Docs was started in the summer of 2019 and is an ongoing effort to improve Team 401 by documenting our procedures and experiences.

## Testing and Running Locally

This site uses [Material for MkDocs](https://squidfunk.github.io/mkdocs-material/), visit their docs to see what customization options are available.

1. Clone this repo by running: `#!bash git clone https://github.com/team401/Docs`

2. Optionally, to avoid installing the Python packages into your user account,
create a virtual environment first:

```bash
python -m venv venv
```

You must activate the environment every time you wish to use it:

```bash
source venv/bin/activate   # on Unix/Linux/macOS
venv\Scripts\activate      # on Windows, command prompt
venv\Scripts\Activate.ps1  # on Windows, PowerShell
```

where `venv` is a name and directory location you can choose.
If you don't set up and activate a virtual environment first,
`pip` will install `MkDocs` into your personal account.

3 Then install Material for MkDocs and its dependencies: `#!bash pip install -r requirements.txt`

4 Serve the site locally: `#!bash mkdocs serve`

## Project layout

``` text linenums="0"
mkdocs.yml    # The configuration file.
docs/
    index.md  # The documentation homepage.
    programming/
        index.md # Programming section homepage
        ... # Other programming files
    ... # Other markdown pages, images and other files.
```

## Recommended VSCode Extensions

- [markdownlint](https://marketplace.visualstudio.com/items?itemName=DavidAnson.vscode-markdownlint) automatically checks for style errors in markdown files.
