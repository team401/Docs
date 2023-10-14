
# 401 Docs

401 Docs was started in the summer of 2019 and is an ongoing effort to improve Team 401 by documenting our procedures and experiences. 

# Contributing

To contribute to 401 Docs please open a pull request.

## Running Locally

To ensure that changes made behave as expected, it is recommended to run the website locally before making a pull request. Steps to do this:
1. Install the latest version of Ruby: [link](https://www.ruby-lang.org/en/downloads/)
2. Open a command line / terminal and navigate to this project's location in the filesystem.
3. Run `bundle install` to install dependencies
4. Run `bundle exec jekyll serve` to run the website and serve it at `localhost:4000`

Putting `localhost:4000` into the URL bar of a web browser will show the website in its current state as long as it is being served. Use `Ctrl+C` to stop serving the website locally. Any changes made to the website will be automatically applied after refreshing the page while the pages are being served.

> Note: Steps 1 and 2 only need to be completed once.


# Troubleshooting

## The website contents aren't updating.
- There may be weird things happening with the compilation. Delete the generated `_site` folder and re-run the `bundle exec jekyll serve` to regenerate the website pages.
- Try a deep refresh of the page to make sure it isn't just the cache.

## The Github Action isn't working

- If you get an error about the version of Ruby/Bundler not supporting Linux, try the following command
```
bundle lock --add-platform x86_64-linux
```
