# Material-SearchTransition

This is a sample project showcasing how a transition to Search can be achieved similar to how it can be found in the [Android stock Dialer app](https://play.google.com/store/apps/details?id=com.google.android.dialer).

The main difference to the implementation found in the stock Dialer app is that you have two separate Activities (MainActivity and SearchActivity) in the demo, as opposed to having a huge activity that has the logic for both.

The searchbar is an actual [`Toolbar`](https://developer.android.com/reference/android/widget/Toolbar.html) view, which allows you to still use all the things you get for free (such as the Navigation button, inflate a custom Menu etc) using the API you already know. No custom views trying to replicate behavior that is given by the system.

The demo is using the [`Transition` API](https://developer.android.com/reference/android/transition/package-summary.html)  with a combination of custom Activity transitions.


### How it looks like

![Transition to Search](https://github.com/alexstyl/Material-SearchTransition/blob/art/transition-to-search.gif?raw=true)

### Jump straight to code

To get started, have a look at the  [MainActivity](https://github.com/alexstyl/Material-SearchTransition/blob/master/app/src/main/java/com/alexstyl/searchtransition/mainscreen/MainActivity.java) class. Enjoy! 



### License
```
MIT License

Copyright (c) 2016 Alex Styl

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
