
# Git Access (Including Tokens)

## Installing Git

Before your can use git, it needs to be installed on your machine

=== "macOS and Linux"
    If you are on a Linux or Macintosh, `git` should already be installed or can
    be installed through the package manager of your OS.

=== "Windows"

    On Windows, follow [this link](https://git-scm.com/) to go to the Git homepage.

    ![Git-Download](../../images/Git-Download.PNG)

    Click the blue download button inside the picture of a computer monitor.  This screenshot shows the Windows version selected, but the link should automatically be set for whatever operating system you are using.

## Using ssh keys and tokens
When you are cloning a private repository, or pushing changes to one, you need
to be authenticated by Github.  This requires the use of a private (ssh) key or of
a token.  For your computer at home, we suggest that you create either
a private (ssh) key, see [instructions](https://docs.github.com/en/authentication/connecting-to-github-with-ssh/adding-a-new-ssh-key-to-your-github-account), or that you create
a classic personal access token (PAT).
For shop computers, we suggest that you create a fine-grained access token
for a specific repository instead.

### Cloning via ssh

On your home machine or personal laptop, if you set up an ssh key, you would use the
`ssh` method of cloning, as shown below using the example of this repository:

![clone from github via ssh](/images/clone-from-github-ssh.png)

However, when using access tokens, you would be using the `https` method instead, which
will be explained below.

### Creating Access Tokens

To create a classic token for home use, go to
[Tokens (classic)](https://github.com/settings/tokens) on github.com.
[This link](https://github.com/settings/tokens) should work, if it doesn't, go to 
Settings, then Developer Settings, then Personal Access Tokens:

![create a personal access token on github](/images/create-pat-on-github.png)

Check the repo box, give it a name and an expiration date, and create the token.
Once created, copy the key and store it somewhere secure. GitHub will
only display it to you once, so it's important to store it elsewhere so
that you can use it to authenticate later.

Your token will look like this: `ghp_rv4djkhsdfEWIkJHSKJfd787fsRV`.

### Creating Fine-grained tokens for shop use

The link to create a fine-grained token is [here](https://github.com/settings/personal-access-tokens).
Enter a name, a description, and **make sure to select team401** as resource owner:

![create a fine-grained token on github](/images/create-fine-grained-token1.png)

Then, select the repository (or repositories) for which the token shall be valid:

![create a fine-grained token on github](/images/create-fine-grained-token2.png)

Shop tokens shall be valid for only one or two repositories.
Finally, click **Add Permissions** and select _Contents_, then select _Read and Write_:

![create a fine-grained token on github](/images/create-fine-grained-token3.png)

(Metadata is Required and will be added automatically).

Finally, select **Generate Token**.  This will send a request to a team organizer.
Let them know about this in person for a quick response!

Team organizers approve the token using [this URL](https://github.com/organizations/team401/settings/personal-access-token-requests).

Once approved, you may start using the token.

### Using created tokens.

These instructions apply to both kinds of tokens.  Once you have obtained a token,
you are able to use this token as follows.
Whenever you are cloning a Github repository, use the `https` method (not `ssh`)
and insert the token in the URL like so: `https://token goes here@github.com/team401/....`.

For instance, the repo for these Docs is at `https://github.com/team401/Docs.git` when using the `https` methods, which is shown here:
![clone from github via https](/images/clone-from-github-https.png)


You would therefore use
`https://ghp_rv4djkhsdfEWIkJHSKJfd787fsRV@github.com/team401/Docs.git` to clone it using your token, for instance,

```bash
git clone https://ghp_rv4djkhsdfEWIkJHSKJfd787fsRV@github.com/team401/Docs.git
```

It is also possible to change the method of authentication after the fact.
We could use this on shared laptops that may be used by multiple students
if they end up working in the same project directory.
For instance, to change the current upstream URL of a repo, use

```bash
git remote set-url origin https://ghp_rv4djkhsdfEWIkJHSKJfd787fsRV@github.com/team401/Docs.git
```

To ensure that commit messages appear under your name, you should also reset
the name and email settings for this repo.

```bash
git config --local user.email your@email
git config --local user.name "Your Name"
```

For shared shop/pit commits, use
```bash
git config --local user.email team401@mcps.org
git config --local user.name "Team 401 shop work@blueridgeramble"
```
or something more specific to describe who participated and when.
(Remember that you must use double quotes if the `user.name` has more than one word.)

*Note* this method is **not** necessary if students work in different project
directories. In that case, the settings from the active project directory will be used.

