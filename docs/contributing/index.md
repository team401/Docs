# Contributing to 401 Docs

This site uses [Material for MkDocs](https://squidfunk.github.io/mkdocs-material/), visit their docs to see what customization options are available. The [uv package manager](https://docs.astral.sh/uv/) is used to handle python packages and virtual environments.

## Running 401 Docs Locally

1. Install uv  
uv provides a standalone installer to download and install uv:

=== "macOS and Linux"

    Use `curl` to download the script and execute it with `sh`:

    ```bash
    curl -LsSf https://astral.sh/uv/install.sh | sh
    ```

    If your system doesn't have `curl`, you can use `wget`:

    ```bash
    wget -qO- https://astral.sh/uv/install.sh | sh
    ```

=== "Windows"

    Use `irm` to download the script and execute it with `iex`:

    ```pwsh
    powershell -ExecutionPolicy ByPass -c "irm https://astral.sh/uv/install.ps1 | iex"
    ```

    Changing the [execution policy](https://learn.microsoft.com/en-us/powershell/module/microsoft.powershell.core/about/about_execution_policies?view=powershell-7.4#powershell-execution-policies) allows running a script from the internet.

2\. Clone this repo:
    ```bash
    git clone https://github.com/team401/Docs
    ```  
3. Install Material for MkDocs and its dependencies:
    ```bash
    uv sync
    ```  
4. Serve the site locally:
    ```bash
    mkdocs serve
    ```

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
- [UV Toolkit](https://marketplace.visualstudio.com/items?itemName=the0807.uv-toolkit) adds uv features to the vscode command palette and adds highlighting.
