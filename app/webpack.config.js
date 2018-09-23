const webpack = require("webpack");
const ExtractTextPlugin = require("extract-text-webpack-plugin");

module.exports = {
  entry: './src/main/js/app.js',
  output: {
    filename: 'bundle.js',
    path: __dirname + '/build/resources/main/static/js'
  },
  module: {
    rules: [
      {
        test: /\.vue$/,
        loader: 'vue-loader',
        options: {
          loaders: {
            css: ExtractTextPlugin.extract({
              use: 'css-loader',
              fallback: 'vue-style-loader' // <- これは vue-loader の依存ですので、npm3 を使用している場合は明示的にインストールする必要はありません
            })
          }
        }
      },
      {
        test: /\.js$/,
        use: 'babel-loader',
        exclude: /node_modules/
      },
      {
        test: /\.css$/,
        use: ExtractTextPlugin.extract({
          fallback: "style-loader",
          use: "css-loader"
        })
      }
      // bootstrap に含まれる font 等を data url に変換する。
//      {test: /\.svg$/, loader: 'url-loader?mimetype=image/svg+xml'},
//      {test: /\.woff$/, loader: 'url-loader?mimetype=application/font-woff'},
//      {test: /\.woff2$/, loader: 'url-loader?mimetype=application/font-woff'},
//      {test: /\.eot$/, loader: 'url-loader?mimetype=application/font-woff'},
//      {test: /\.ttf$/, loader: 'url-loader?mimetype=application/font-woff'}
    ]
  },
  plugins: [
    new ExtractTextPlugin("styles.css"),
  ]
}
;
